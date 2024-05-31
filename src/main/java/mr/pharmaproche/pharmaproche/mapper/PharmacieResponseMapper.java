package mr.pharmaproche.pharmaproche.mapper;

import mr.pharmaproche.pharmaproche.collection.PharmacieResponse;
import mr.pharmaproche.pharmaproche.collection.dto.PharmacieResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PharmacieResponseMapper {

    @Autowired
    private PharmacieMapper pharmacieMapper;
    @Autowired
    private UserRequestMapper requestMapper;

    public PharmacieResponseDTO pharmacieResponseToDTO(PharmacieResponse response) {
        if(response == null) {
            return null;
        }
        return PharmacieResponseDTO.builder()
                .id(response.getId())
                .price(response.getPrice())
                .availability(response.getAvailability())
                .createdAt(response.getCreatedAt())
                .userRequestId(response.getUserRequestId())
                .pharmacieId(response.getPharmacieId())
                .build();
    }

    public PharmacieResponse dtoToPharmacieResponse(PharmacieResponseDTO responseDTO) {
        if(responseDTO == null) {
            return null;
        }
        return PharmacieResponse.builder()
                .id(responseDTO.getId())
                .price(responseDTO.getPrice())
                .availability(responseDTO.getAvailability())
                .createdAt(responseDTO.getCreatedAt())
                .userRequestId(responseDTO.getUserRequestId())
                .pharmacieId(responseDTO.getPharmacieId())
                .build();
    }
}
