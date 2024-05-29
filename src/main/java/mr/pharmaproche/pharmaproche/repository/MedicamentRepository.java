package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.collection.Medicament;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends MongoRepository<Medicament, String> {
}

