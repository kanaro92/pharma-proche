package mr.pharmaproche.pharmaproche.controller;

import mr.pharmaproche.pharmaproche.collection.Pharmacie;
import mr.pharmaproche.pharmaproche.collection.User;
import mr.pharmaproche.pharmaproche.collection.dto.UserDTO;
import mr.pharmaproche.pharmaproche.registration.RegistrationRequest;
import mr.pharmaproche.pharmaproche.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pharma-proche/user")
public class UserController {

    //todo implement reactive prog with reactor

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public Page<User> search(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.search(firstName, lastName, email, pageable);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUserStartWith")
    public List<UserDTO> getUserStartWith(@RequestParam("firstName") String firstName) {
        return userService.getUserStartWith(firstName);
    }

    @PostMapping("/saveUser")
    public String save(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @PostMapping("/registerUser")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest) {
        return userService.registerUser(registrationRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
}
