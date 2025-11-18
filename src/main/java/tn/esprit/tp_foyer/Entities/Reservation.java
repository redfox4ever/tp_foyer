package tn.esprit.tp_foyer.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    @Id
    String idReservation;
    Date anneeUniversitaire;
    boolean estValide;
    @ManyToMany
    private Set<Etudiant> etudiants = new HashSet<>();;

}
