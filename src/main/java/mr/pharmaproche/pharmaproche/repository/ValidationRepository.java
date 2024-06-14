package mr.pharmaproche.pharmaproche.repository;

import mr.pharmaproche.pharmaproche.model.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Long> {

    Optional<Validation> findByCode(String code);
}