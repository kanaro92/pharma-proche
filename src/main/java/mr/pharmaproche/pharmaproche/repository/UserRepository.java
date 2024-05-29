package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByFirstNameStartsWith(String firstName);

    Optional<User> findByEmail(String email);

}
