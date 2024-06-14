package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.model.AppUser;
import mr.pharmaproche.pharmaproche.model.dto.UserDTO;
import mr.pharmaproche.pharmaproche.registration.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<AppUser> getUsers();

    Long save(UserDTO user);

    List<UserDTO> getUserStartWith(String firstName);

    void delete(Long id);

    String registerUser(RegistrationRequest registrationRequest);
}
