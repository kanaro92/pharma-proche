package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
}

