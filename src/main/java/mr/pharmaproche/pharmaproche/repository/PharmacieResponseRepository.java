package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.model.PharmacieResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacieResponseRepository extends JpaRepository<PharmacieResponse, Long> {

    List<PharmacieResponse> findPharmacieResponseByUserRequestId(Long userRequestId);
}

