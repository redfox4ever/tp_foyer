package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Bloc;
import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc retrieveBloc(Long blocId);
    Bloc addBloc(Bloc b);
    void removeBloc(Long blocId);
    Bloc modifyBloc(Bloc bloc);
}
