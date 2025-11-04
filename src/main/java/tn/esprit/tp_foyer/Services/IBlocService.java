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
}
