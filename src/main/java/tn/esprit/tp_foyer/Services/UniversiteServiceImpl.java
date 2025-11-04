package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.DTO.BlocDTO;
import tn.esprit.tp_foyer.DTO.UniversiteDTO;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Universite;
import tn.esprit.tp_foyer.Repositories.UniversiteRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepository universiteRepository;

    public List<UniversiteDTO> retrieveAllUniversites() {
        return universiteRepository.findAll().stream()
                .map(UniversiteServiceImpl::convertToDto)
                .collect(Collectors.toList());
    }

    public Universite retrieveUniversite(Long universiteId) {
        return universiteRepository.findById(universiteId).get();
    }

    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    public void removeUniversite(Long universiteId) {
        universiteRepository.deleteById(universiteId);
    }

    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    public static Set<UniversiteDTO> convertToDtoSet(Set<Universite> universites) {
        if (universites == null) return Set.of();
        return universites.stream()
                .map(UniversiteServiceImpl::convertToDto)
                .collect(Collectors.toSet());
    }

    public static UniversiteDTO convertToDto(Universite universite) {
        if (universite == null) return null;

        UniversiteDTO universiteDTO = new UniversiteDTO();
        universiteDTO.setNomUniversite(universite.getNomUniversite());
        universiteDTO.setAdresse(universite.getAdresse());
        universiteDTO.setFoyer(
                FoyerServiceImpl.convertToDto(universite.getFoyer())
        );

        return universiteDTO;
    }
}

