package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.collection.User;
import mr.pharmaproche.pharmaproche.collection.dto.UserDTO;
import mr.pharmaproche.pharmaproche.registration.RegistrationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    String save(UserDTO user);

    List<UserDTO> getUserStartWith(String firstName);

    void delete(String id);

    Page<User> search(String firstName, String lastName, String email, Pageable pageable);

    String registerUser(RegistrationRequest registrationRequest);
}
