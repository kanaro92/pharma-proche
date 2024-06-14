package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.model.Pharmacie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PharmacieService {
    List<Pharmacie> getPharmacies();

    Long save(Pharmacie pharmacie);

    Page<Pharmacie> search(String name, String phone, String email, Pageable pageable);

    void delete(Long id);
}
