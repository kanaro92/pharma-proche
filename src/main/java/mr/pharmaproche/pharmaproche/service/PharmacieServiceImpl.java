package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.collection.Pharmacie;
import mr.pharmaproche.pharmaproche.repository.PharmacieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacieServiceImpl implements PharmacieService{

    private final PharmacieRepository pharmacieRepository;

    public PharmacieServiceImpl(PharmacieRepository pharmacieRepository) {
        this.pharmacieRepository = pharmacieRepository;
    }

    @Override
    public List<Pharmacie> getPharmacies() {
        return pharmacieRepository.findAll();
    }

    @Override
    public String save(Pharmacie pharmacie) {
        return pharmacieRepository.save(pharmacie).getId();
    }

    @Override
    public Page<Pharmacie> search(String name, String phone, String email, Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {
        pharmacieRepository.deleteById(id);
    }
}
