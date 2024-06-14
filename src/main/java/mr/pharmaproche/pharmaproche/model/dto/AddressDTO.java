package mr.pharmaproche.pharmaproche.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;
    private String city;
    private String country;
    private String postalCode;
    private String street;

}
