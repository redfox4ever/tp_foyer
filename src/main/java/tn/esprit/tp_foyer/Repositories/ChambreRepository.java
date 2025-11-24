package tn.esprit.tp_foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findByTypeC(TypeChambre typeC);

    List<Chambre> findByNumeroChambre(long numeroChambre);
}
