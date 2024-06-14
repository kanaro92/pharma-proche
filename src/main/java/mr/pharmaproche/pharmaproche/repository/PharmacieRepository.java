package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.model.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {

}
