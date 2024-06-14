package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.model.PharmacieResponse;

import java.util.List;

public interface PharmacieResponseService {
    List<PharmacieResponse> getPharmacieResponses();

    Long save(PharmacieResponse pharmacieResponse);

    void delete(Long id);

    List<PharmacieResponse> getPharmacieResponseByUserRequestId(Long userRequestId);
}
