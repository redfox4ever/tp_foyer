package tn.esprit.tp_foyer.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Reservation;
import tn.esprit.tp_foyer.Entities.TypeChambre;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDTO {
    long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;
    private BlocDTO bloc;
    private Set<ReservationDTO> reservations;
}
