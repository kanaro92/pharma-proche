package mr.pharmaproche.pharmaproche.collection.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private String city;
    private String country;
    private String postalCode;
    private String street;

}
