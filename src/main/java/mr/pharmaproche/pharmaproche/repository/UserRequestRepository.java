package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.collection.UserRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRequestRepository extends MongoRepository<UserRequest, String> {

    List<UserRequest> findUserRequestByUserId(String userId);
}

