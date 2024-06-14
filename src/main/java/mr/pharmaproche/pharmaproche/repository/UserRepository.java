package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findByFirstNameStartsWith(String firstName);

    Optional<AppUser> findByEmail(String email);

}
