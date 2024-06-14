package mr.pharmaproche.pharmaproche.mapper;

import mr.pharmaproche.pharmaproche.model.PharmacieResponse;
import mr.pharmaproche.pharmaproche.model.dto.PharmacieResponseDTO;
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
                .userRequest(requestMapper.userRequestToDTO(response.getUserRequest()))
                .pharmacie(pharmacieMapper.pharmacieToDTO(response.getPharmacie()))
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
                .userRequest(requestMapper.dtoToUserRequest(responseDTO.getUserRequest()))
                .pharmacie(pharmacieMapper.dtoPharmacie(responseDTO.getPharmacie()))
                .build();
    }
}
