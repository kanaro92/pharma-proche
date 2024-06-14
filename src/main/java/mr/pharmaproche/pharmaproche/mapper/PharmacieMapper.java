package mr.pharmaproche.pharmaproche.mapper;

import mr.pharmaproche.pharmaproche.model.Pharmacie;
import mr.pharmaproche.pharmaproche.model.dto.PharmacieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PharmacieMapper {

    @Autowired
    private AddressMapper addressMapper;

    public PharmacieDTO pharmacieToDTO(Pharmacie pharmacie) {
        if(pharmacie == null) {
            return null;
        }
        return PharmacieDTO.builder()
                .id(pharmacie.getId())
                .name(pharmacie.getName())
                .phone(pharmacie.getPhone())
                .email(pharmacie.getEmail())
                .address(addressMapper.addressToDTO(pharmacie.getAddress()))
                .build();
    }

    public Pharmacie dtoPharmacie(PharmacieDTO pharmacieDTO) {
        if(pharmacieDTO == null) {
            return null;
        }
        return Pharmacie.builder()
                .id(pharmacieDTO.getId())
                .name(pharmacieDTO.getName())
                .phone(pharmacieDTO.getPhone())
                .email(pharmacieDTO.getEmail())
                .address(addressMapper.dtoToAddress(pharmacieDTO.getAddress()))
                .build();
    }
}
