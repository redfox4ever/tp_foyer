package tn.esprit.tp_foyer.DTO;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.Foyer;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BlocDTO {
    String nomBloc;
    long capaciteBloc;
    private FoyerDTO foyer;
    private Set<ChambreDTO> chambres;
}
