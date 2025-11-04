package tn.esprit.tp_foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
