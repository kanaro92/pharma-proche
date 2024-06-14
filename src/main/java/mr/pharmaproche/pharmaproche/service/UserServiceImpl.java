package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.mapper.UserMapper;
import mr.pharmaproche.pharmaproche.model.AppUser;
import mr.pharmaproche.pharmaproche.model.Role;
import mr.pharmaproche.pharmaproche.model.dto.UserDTO;
import mr.pharmaproche.pharmaproche.model.enums.UserRole;
import mr.pharmaproche.pharmaproche.registration.RegistrationRequest;
import mr.pharmaproche.pharmaproche.registration.token.ConfirmationTokenService;
import mr.pharmaproche.pharmaproche.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ValidationService validationService;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ValidationService validationService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.validationService = validationService;
        this.userMapper = userMapper;
    }


    @Override
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Long save(UserDTO user) {
        return userRepository.save(userMapper.dtoToUser(user)).getId();
    }

    @Override
    public List<UserDTO> getUserStartWith(String firstName) {
        return userMapper.usersToDTOs(userRepository.findByFirstNameStartsWith(firstName));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public String registerUser(RegistrationRequest registrationRequest) {
        if(!registrationRequest.email().contains("@") || !registrationRequest.email().contains(".")) {
            throw  new RuntimeException("Votre email invalide");
        }

        boolean userExists = this.userRepository.findByEmail(registrationRequest.email()).isPresent();
        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("Cet email est déjà utilisé");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(registrationRequest.password());
        Role role = Role.builder().userRole(UserRole.ADMIN).build();
        AppUser user = AppUser.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .phone(registrationRequest.phone())
                .role(role)
                .password(encodedPassword)
                .active(true)
                .build();
                userRepository.save(user);

//        TODO: SEND EMAIL
        this.validationService.save(user);

        return user.getEmail();
    }

    @Override
    public AppUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé: "+username));
    }
}
