package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.DTO.FoyerDTO;
import tn.esprit.tp_foyer.Entities.Foyer;
import java.util.List;

public interface IFoyerService {
    List<FoyerDTO> retrieveAllFoyers();
    Foyer retrieveFoyer(Long foyerId);
    Foyer addFoyer(Foyer f);
    void removeFoyer(Long foyerId);
    Foyer modifyFoyer(Foyer foyer);
}

