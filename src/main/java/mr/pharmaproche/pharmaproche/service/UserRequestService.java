package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.model.UserRequest;

import java.util.List;

public interface UserRequestService {

    Long searchMedicament(UserRequest userRequest);

    List<UserRequest> getUserRequestByUserId(Long userId);
}
