package tn.esprit.tp_foyer.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite {
    @Id
    long idUniversite;
    String nomUniversite;
    String adresse;
    @OneToOne
    private Foyer foyer;
}
