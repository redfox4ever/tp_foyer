package tn.esprit.tp_foyer.DTO;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tp_foyer.Entities.Foyer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UniversiteDTO {
    String nomUniversite;
    String adresse;
    private FoyerDTO foyer;
}
