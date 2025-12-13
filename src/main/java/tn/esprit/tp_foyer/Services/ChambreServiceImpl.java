package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.DTO.BlocDTO;
import tn.esprit.tp_foyer.DTO.ChambreDTO;
import tn.esprit.tp_foyer.Entities.*;
import tn.esprit.tp_foyer.Mapper.BlocMapper;
import tn.esprit.tp_foyer.Mapper.ChambreMapper;
import tn.esprit.tp_foyer.Repositories.ChambreRepository;
import tn.esprit.tp_foyer.Repositories.ReservationRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import tn.esprit.tp_foyer.Entities.TypeChambre;

@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;
    private final ChambreMapper chambreMapper;
    ReservationRepository reservationRepository;
    public List<ChambreDTO> retrieveAllChambres() {  
        return chambreRepository.findAll().stream()
                .map(chambreMapper::toDto)
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

    public Chambre addChambreWithReservation(Chambre chambre) {
        chambreRepository.save(chambre);
        reservationRepository.saveAll(chambre.getReservations());
        return chambre;
    }

    public Chambre assignReservationToChambre(String reservationId, long chambreId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Chambre chambre = chambreRepository.findById(chambreId).get();
        chambre.getReservations().add(reservation);
        chambreRepository.save(chambre);
        return chambre;
    }

    public Chambre unassignReservationToChambre(String reservationId, long chambreId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Chambre chambre = chambreRepository.findById(chambreId).get();
        chambre.getReservations().remove(reservation);
        chambreRepository.save(chambre);
        return chambre;
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
        if (chambre == null) return null;
        ChambreDTO chambreDTO = new ChambreDTO();
        chambreDTO.setNumeroChambre(chambre.getNumeroChambre());
        chambreDTO.setReservations(ReservationServiceImpl.convertToDtoSet(chambre.getReservations()));
        chambreDTO.setBloc(BlocServiceImpl.convertToDto(chambre.getBloc()));
        chambreDTO.setTypeC(chambre.getTypeC());
        return chambreDTO;





    }

    public List<Chambre> findByTypeC(TypeChambre typeC)
    {
        return  chambreRepository.findByTypeC(typeC);
    }

    public List<Chambre> findByNumeroChambre(long numeroChambre)
    {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void pourcentageChambreParTypeChambre()
    {
        long numberOfRooms = chambreRepository.findAll().stream().count();
        long numberOfSimpleRooms = chambreRepository.findByTypeC(TypeChambre.SIMPLE).stream().count();
        long numberOfDoubleRooms = chambreRepository.findByTypeC(TypeChambre.DOUBLE).stream().count();
        long numberOfTripleRooms = chambreRepository.findByTypeC(TypeChambre.TRIPLE).stream().count();


        log.info("Nomre total des chambres: "+ numberOfRooms);

        log.info("Le pourcentage de type SIMPLE: "+ numberOfSimpleRooms/numberOfRooms * 100);
        log.info("Le pourcentage de type DOUBLE: "+ numberOfDoubleRooms/numberOfRooms * 100);
        log.info("Le pourcentage de type TRIPLE: "+ numberOfTripleRooms/numberOfRooms * 100);
    }

    public Chambre findChambreByEtudiantCin(long cin)
    {
        return chambreRepository.findChambreByEtudiantCin(cin);
    }

}
