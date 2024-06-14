package mr.pharmaproche.pharmaproche.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String medicament;
    private String latitude;
    private String longitude;
    private LocalDateTime createdAt;
    @ManyToOne
    private AppUser user;

}
