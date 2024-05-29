package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.collection.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
