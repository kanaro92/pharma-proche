package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.collection.User;
import mr.pharmaproche.pharmaproche.collection.dto.UserDTO;
import mr.pharmaproche.pharmaproche.mapper.UserMapper;
import mr.pharmaproche.pharmaproche.registration.RegistrationRequest;
import mr.pharmaproche.pharmaproche.registration.token.ConfirmationToken;
import mr.pharmaproche.pharmaproche.registration.token.ConfirmationTokenService;
import mr.pharmaproche.pharmaproche.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, MongoTemplate mongoTemplate, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public String save(UserDTO user) {
        return userRepository.save(userMapper.dtoToUser(user)).getId();
    }

    @Override
    public List<UserDTO> getUserStartWith(String firstName) {
        return userMapper.usersToDTOs(userRepository.findByFirstNameStartsWith(firstName));
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> search(String firstName, String lastName, String email, Pageable pageable) {
        Query query = new Query().with(pageable);
        List<Criteria> criteria = new ArrayList<>();
        if (firstName != null && !firstName.isEmpty()) {
            criteria.add(Criteria.where("firstName").regex(firstName , "i"));
        }
        if (lastName != null && !lastName.isEmpty()) {
            criteria.add(Criteria.where("lastName").regex(lastName , "i"));
        }
        if (email != null && !email.isEmpty()) {
            criteria.add(Criteria.where("email").regex(email , "i"));
        }
        if(!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }
        return PageableExecutionUtils.getPage(
                mongoTemplate.find(
                        query,
                        User.class
                ), pageable, () -> mongoTemplate.count(query.skip(0).limit(0),User.class)
        );
    }

    @Override
    public String registerUser(RegistrationRequest registrationRequest) {
        boolean userExists = userRepository.findByEmail(registrationRequest.email()).isPresent();
        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("username already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(registrationRequest.password());
        User user = User.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .phone(registrationRequest.phone())
                .userRole(registrationRequest.role())
                .password(encodedPassword)
                .build();
        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = ConfirmationToken.builder()
                .token(token)
                .createdAt(LocalDateTime.now())
                .confirmedAt(LocalDateTime.now())
                .confirmedAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();

        confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }
}
