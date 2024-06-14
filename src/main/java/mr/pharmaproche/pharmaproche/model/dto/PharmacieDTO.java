package mr.pharmaproche.pharmaproche.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PharmacieDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private AddressDTO address;

}
