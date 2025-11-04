package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.DTO.EtudiantDTO;
import tn.esprit.tp_foyer.Entities.Etudiant;
import java.util.List;

public interface IEtudiantService {
    List<EtudiantDTO> retrieveAllEtudiants();
    Etudiant retrieveEtudiant(Long etudiantId);
    Etudiant addEtudiant(Etudiant e);
    void removeEtudiant(Long etudiantId);
    Etudiant modifyEtudiant(Etudiant etudiant);
}
