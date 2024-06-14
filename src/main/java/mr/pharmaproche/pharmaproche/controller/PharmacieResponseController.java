package mr.pharmaproche.pharmaproche.controller;

import mr.pharmaproche.pharmaproche.model.PharmacieResponse;
import mr.pharmaproche.pharmaproche.service.PharmacieResponseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pharma-proche/pharmacie-response")
public class PharmacieResponseController {

    private final PharmacieResponseService pharmacieResponseService;

    public PharmacieResponseController(PharmacieResponseService pharmacieResponseService) {
        this.pharmacieResponseService = pharmacieResponseService;
    }

    @GetMapping("/getPharmacieResponseByUserRequestId/{userRequestId}")
    public List<PharmacieResponse> getPharmacieResponseByUserRequestId(@PathVariable Long userRequestId) {
        return pharmacieResponseService.getPharmacieResponseByUserRequestId(userRequestId);
    }

    @PostMapping
    public Long save(@RequestBody PharmacieResponse pharmacieResponse) {
        return pharmacieResponseService.save(pharmacieResponse);
    }

}
