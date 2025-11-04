package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.DTO.BlocDTO;
import tn.esprit.tp_foyer.DTO.EtudiantDTO;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Etudiant;
import tn.esprit.tp_foyer.Repositories.EtudiantRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepository etudiantRepository;

    public List<EtudiantDTO> retrieveAllEtudiants() {
        return etudiantRepository.findAll().stream()
                .map(EtudiantServiceImpl::convertToDto)
                .collect(Collectors.toList());
    }

    public Etudiant retrieveEtudiant(Long etudiantId) {
        return etudiantRepository.findById(etudiantId).get();
    }

    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    public void removeEtudiant(Long etudiantId) {
        etudiantRepository.deleteById(etudiantId);
    }

    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public static Set<EtudiantDTO> convertToDtoSet(Set<Etudiant> etudiants)
    {
        if (etudiants == null) return Set.of();
        return etudiants.stream()
                .map(EtudiantServiceImpl::convertToDto)
                .collect(Collectors.toSet());
    }
    public static EtudiantDTO convertToDto(Etudiant etudiant)
    {
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        etudiantDTO.setCin(etudiant.getCin());
        etudiantDTO.setEcole(etudiant.getEcole());
        etudiantDTO.setNomEt(etudiantDTO.getNomEt());
        etudiantDTO.setPrenomEt(etudiantDTO.getPrenomEt());
        etudiantDTO.setDateNaissance(etudiant.getDateNaissance());
        etudiantDTO.setReservations(ReservationServiceImpl.convertToDtoSet(etudiant.getReservations()));
        return etudiantDTO;


    }
}

