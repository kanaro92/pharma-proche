package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
