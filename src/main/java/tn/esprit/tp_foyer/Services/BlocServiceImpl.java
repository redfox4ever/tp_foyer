package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.DTO.BlocDTO;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Foyer;
import tn.esprit.tp_foyer.Mapper.BlocMapper;
import tn.esprit.tp_foyer.Repositories.BlocRepository;
import tn.esprit.tp_foyer.Repositories.FoyerRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    BlocRepository blocRepository;
    FoyerRepository foyerRepository;
    private final BlocMapper blocMapper;

    public List<BlocDTO> retrieveAllBlocs() {
        return blocRepository.findAll().stream()
                .map(blocMapper::toDto)
                .collect(Collectors.toList());
    }


    public BlocDTO retrieveBloc(Long blocId) {
        return blocMapper.toDto(blocRepository.findById(blocId).get());
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

    public Bloc addBlocWithFoyer(Bloc bloc) {
        Foyer foyer = bloc.getFoyer();
        foyer.getBlocs().add(bloc);
        blocRepository.save(bloc);
        foyerRepository.save(foyer);

        return bloc;
    }

    public Bloc assignBlocToFoyer(long blocId, long foyerId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        Foyer foyer = foyerRepository.findById(foyerId).get();
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
        return bloc;
    }

    public Bloc unassignBlocToFoyer(long blocId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        bloc.setFoyer(null);
        blocRepository.save(bloc);
        return bloc;
    }

    public static Set<BlocDTO> convertToDtoSet(Set<Bloc> blocs)
    {
        if (blocs == null) return Set.of();
        return blocs.stream()
                .map(BlocServiceImpl::convertToDto)
                .collect(Collectors.toSet());
    }
    public static BlocDTO convertToDto(Bloc bloc)
    {
        BlocDTO blocDTO = new BlocDTO();
        blocDTO.setCapaciteBloc(bloc.getCapaciteBloc());
        blocDTO.setNomBloc(bloc.getNomBloc());
        blocDTO.setChambres(ChambreServiceImpl.convertToDtoSet(bloc.getChambres()));
        blocDTO.setFoyer(FoyerServiceImpl.convertToDto(bloc.getFoyer()));

        return  blocDTO;

    }
}

