package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.collection.PharmacieResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacieResponseRepository extends MongoRepository<PharmacieResponse, String> {

    List<PharmacieResponse> findPharmacieResponseByUserRequestId(String userRequestId);
}

