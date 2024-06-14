package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.model.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Long> {

    List<UserRequest> findUserRequestByUserId(Long userId);
}

