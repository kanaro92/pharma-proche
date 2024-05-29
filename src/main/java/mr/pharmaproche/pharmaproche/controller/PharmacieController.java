package mr.pharmaproche.pharmaproche.controller;

import mr.pharmaproche.pharmaproche.collection.Pharmacie;
import mr.pharmaproche.pharmaproche.collection.User;
import mr.pharmaproche.pharmaproche.service.PharmacieService;
import mr.pharmaproche.pharmaproche.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pharma-proche/pharmacie")
public class PharmacieController {

    private final PharmacieService pharmacieService;

    public PharmacieController(PharmacieService pharmacieService) {
        this.pharmacieService = pharmacieService;
    }

    @GetMapping("/search")
    public Page<Pharmacie> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return pharmacieService.search(name, phone, email, pageable);
    }

    @GetMapping
    public List<Pharmacie> getPharmacies() {
        return pharmacieService.getPharmacies();
    }

    @PostMapping
    public String save(@RequestBody Pharmacie pharmacie) {
        return pharmacieService.save(pharmacie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        pharmacieService.delete(id);
    }
}
