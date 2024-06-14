package mr.pharmaproche.pharmaproche.controller;

import mr.pharmaproche.pharmaproche.model.AppUser;
import mr.pharmaproche.pharmaproche.model.dto.UserDTO;
import mr.pharmaproche.pharmaproche.registration.RegistrationRequest;
import mr.pharmaproche.pharmaproche.service.UserServiceImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pharma-proche/user")
public class UserController {

    //todo implement reactive prog with reactor

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAnyAuthority('GGG')")
    @GetMapping("/getUsers")
    public List<AppUser> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUserStartWith")
    public List<UserDTO> getUserStartWith(@RequestParam("firstName") String firstName) {
        return userService.getUserStartWith(firstName);
    }

    @PostMapping("/saveUser")
    public Long save(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @PostMapping("/registerUser")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest) {
        return userService.registerUser(registrationRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
