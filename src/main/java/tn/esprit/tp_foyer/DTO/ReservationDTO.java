package tn.esprit.tp_foyer.DTO;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tp_foyer.Entities.Etudiant;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    Date anneeUniversitaire;
    boolean estValide;
    private Set<EtudiantDTO> etudiants;
}
