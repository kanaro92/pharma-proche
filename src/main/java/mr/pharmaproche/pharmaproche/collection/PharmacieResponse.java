package mr.pharmaproche.pharmaproche.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pharmacie_response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PharmacieResponse {

    @Id
    private String id;
    private Double price;
    private Boolean availability;
    private LocalDateTime createdAt;
    private String userRequestId;
    private String pharmacieId;

}
