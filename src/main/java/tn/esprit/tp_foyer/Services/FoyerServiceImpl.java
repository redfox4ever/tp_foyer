package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.DTO.BlocDTO;
import tn.esprit.tp_foyer.DTO.FoyerDTO;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Foyer;
import tn.esprit.tp_foyer.Repositories.FoyerRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foyerRepository;

    public List<FoyerDTO> retrieveAllFoyers() {
        return foyerRepository.findAll().stream()
                .map(FoyerServiceImpl::convertToDto)
                .collect(Collectors.toList());
    }

    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepository.findById(foyerId).get();
    }

    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    public void removeFoyer(Long foyerId) {
        foyerRepository.deleteById(foyerId);
    }

    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public static Set<FoyerDTO> convertToDtoSet(Set<Foyer> foyers) {
        if (foyers == null) return Set.of();
        return foyers.stream()
                .map(FoyerServiceImpl::convertToDto)
                .collect(Collectors.toSet());
    }

    public static FoyerDTO convertToDto(Foyer foyer) {
        if (foyer == null) return null;

        FoyerDTO foyerDTO = new FoyerDTO();
        foyerDTO.setNomFoyer(foyer.getNomFoyer());
        foyerDTO.setCapaciteFoyer(foyer.getCapaciteFoyer());

        foyerDTO.setUniversite(
                UniversiteServiceImpl.convertToDto(foyer.getUniversite())
        );

        foyerDTO.setBlocs(
                BlocServiceImpl.convertToDtoSet(foyer.getBlocs())
        );

        return foyerDTO;
    }
}

