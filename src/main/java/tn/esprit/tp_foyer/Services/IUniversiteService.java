package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Universite;
import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite retrieveUniversite(Long universiteId);
    Universite addUniversite(Universite u);
    void removeUniversite(Long universiteId);
    Universite modifyUniversite(Universite universite);
}

