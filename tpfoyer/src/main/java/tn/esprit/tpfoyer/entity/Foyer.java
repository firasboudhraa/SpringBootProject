package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer ;

    private String nomFoyer ;
    private Long capaciteFoyer ;

    @OneToOne(mappedBy = "foyer")
    private Universite universite ;

    @OneToMany( mappedBy = "foyer")
    @ToString.Exclude
    @JsonIgnore
    private Set<Bloc> blocs ;
}