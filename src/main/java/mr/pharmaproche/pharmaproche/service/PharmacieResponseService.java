package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.collection.PharmacieResponse;

import java.util.List;

public interface PharmacieResponseService {
    List<PharmacieResponse> getPharmacieResponses();

    String save(PharmacieResponse pharmacieResponse);

    void delete(String id);

    List<PharmacieResponse> getPharmacieResponseByUserRequestId(String userRequestId);
}
