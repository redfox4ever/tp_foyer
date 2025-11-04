package tn.esprit.tp_foyer.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEtudiant;
    String nomEt;
    String prenomEt;
    long cin;
    String ecole;
    Date dateNaissance;
    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;
}
