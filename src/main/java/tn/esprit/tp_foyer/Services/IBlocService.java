package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.DTO.BlocDTO;
import tn.esprit.tp_foyer.Entities.Bloc;
import java.util.List;

public interface IBlocService {
    List<BlocDTO> retrieveAllBlocs();
    BlocDTO retrieveBloc(Long blocId);
    Bloc addBloc(Bloc b);
    void removeBloc(Long blocId);
    Bloc modifyBloc(Bloc bloc);
    Bloc assignBlocToFoyer(long blocId, long foyerId);
    Bloc unassignBlocToFoyer(long blocId);
    Bloc addBlocWithFoyer(Bloc bloc);


    List<Bloc> findByFoyerIsNull();

    List<Bloc> findByCapaciteBlocGreaterThan(long count);

    List<Bloc> findByNomBlocStartingWith(String nomBloc);

    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String nomBloc, long count);
    void listeChambresParBloc();
}
