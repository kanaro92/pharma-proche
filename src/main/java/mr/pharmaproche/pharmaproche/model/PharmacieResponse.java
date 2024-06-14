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
public class PharmacieResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    private Boolean availability;
    private LocalDateTime createdAt;
    @ManyToOne
    private Pharmacie pharmacie;
    @OneToOne
    private UserRequest userRequest;
}
