package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.collection.UserRequest;

import java.util.List;

public interface UserRequestService {

    String searchMedicament(UserRequest userRequest);

    List<UserRequest> getUserRequestByUserId(String userId);
}
