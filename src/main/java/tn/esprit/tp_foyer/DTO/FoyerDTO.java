package tn.esprit.tp_foyer.DTO;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Universite;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoyerDTO {
    String nomFoyer;
    long capaciteFoyer;
    private UniversiteDTO universite;
    Set<BlocDTO> blocs;
}
