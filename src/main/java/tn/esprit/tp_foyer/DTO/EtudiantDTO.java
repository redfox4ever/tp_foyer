package tn.esprit.tp_foyer.DTO;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tp_foyer.Entities.Reservation;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDTO {
    String nomEt;
    String prenomEt;
    long cin;
    String ecole;
    Date dateNaissance;
    private Set<ReservationDTO> reservations;
}
