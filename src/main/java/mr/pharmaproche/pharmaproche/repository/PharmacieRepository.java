package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.collection.Pharmacie;
import mr.pharmaproche.pharmaproche.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacieRepository extends MongoRepository<Pharmacie, String> {

}
