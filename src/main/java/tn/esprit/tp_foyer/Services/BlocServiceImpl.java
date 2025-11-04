package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Repositories.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    BlocRepository blocRepository;

    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }

    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
}

