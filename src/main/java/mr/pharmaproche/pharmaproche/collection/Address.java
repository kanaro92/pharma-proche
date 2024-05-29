package mr.pharmaproche.pharmaproche.collection;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    private String country;
    private String postalCode;
    private String street;

}
