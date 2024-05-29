package mr.pharmaproche.pharmaproche.mapper;

import mr.pharmaproche.pharmaproche.collection.Address;
import mr.pharmaproche.pharmaproche.collection.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO addressToDTO(Address address) {
        if(address == null) {
            return null;
        }
        return AddressDTO.builder()
                .city(address.getCity())
                .country(address.getCountry())
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .build();
    }

    public Address dtoToAddress(AddressDTO addressDTO) {
        if(addressDTO == null) {
            return null;
        }
        return Address.builder()
                .city(addressDTO.getCity())
                .country(addressDTO.getCountry())
                .street(addressDTO.getStreet())
                .postalCode(addressDTO.getPostalCode())
                .build();
    }
}
