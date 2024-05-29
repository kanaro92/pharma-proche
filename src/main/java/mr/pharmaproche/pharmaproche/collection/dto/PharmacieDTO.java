package mr.pharmaproche.pharmaproche.collection.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PharmacieDTO {

    private String id;
    private String name;
    private String phone;
    private String email;
    private AddressDTO address;

}
