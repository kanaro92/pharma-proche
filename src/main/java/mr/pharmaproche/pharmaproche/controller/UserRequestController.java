package mr.pharmaproche.pharmaproche.controller;

import mr.pharmaproche.pharmaproche.model.UserRequest;
import mr.pharmaproche.pharmaproche.service.UserRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pharma-proche/user-request")
public class UserRequestController {

    private final UserRequestService userRequestService;

    public UserRequestController(UserRequestService userRequestService) {
        this.userRequestService = userRequestService;
    }


    @GetMapping("/getUserRequestByUserId/{userId}")
    public List<UserRequest> getUserRequestByUserId(@PathVariable Long userId) {
        return userRequestService.getUserRequestByUserId(userId);
    }

    @PostMapping("/search-medicament")
    public Long searchMedicament(@RequestBody UserRequest userRequest) {
        return userRequestService.searchMedicament(userRequest);
    }

}
