package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.DTO.BlocDTO;
import tn.esprit.tp_foyer.DTO.ChambreDTO;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Repositories.ChambreRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;

    public List<ChambreDTO> retrieveAllChambres() {  
        return chambreRepository.findAll().stream()
                .map(ChambreServiceImpl::convertToDto)
                .collect(Collectors.toList());
    }

    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }

    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }

    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public static Set<ChambreDTO> convertToDtoSet(Set<Chambre> chambres)
    {
        if (chambres == null) return Set.of();
        return chambres.stream()
                .map(ChambreServiceImpl::convertToDto)
                .collect(Collectors.toSet());
    }
    public static ChambreDTO convertToDto(Chambre chambre)
    {
        ChambreDTO chambreDTO = new ChambreDTO();
        chambreDTO.setNumeroChambre(chambre.getNumeroChambre());
        chambreDTO.setReservations(ReservationServiceImpl.convertToDtoSet(chambre.getReservations()));
        chambreDTO.setBloc(BlocServiceImpl.convertToDto(chambre.getBloc()));
        chambreDTO.setTypeC(chambre.getTypeC());
        return chambreDTO;





    }
}
