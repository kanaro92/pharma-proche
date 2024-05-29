package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.collection.Pharmacie;
import mr.pharmaproche.pharmaproche.collection.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PharmacieService {
    List<Pharmacie> getPharmacies();

    String save(Pharmacie pharmacie);

    Page<Pharmacie> search(String name, String phone, String email, Pageable pageable);

    void delete(String id);
}
