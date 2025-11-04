package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.DTO.ReservationDTO;
import tn.esprit.tp_foyer.Entities.Reservation;
import tn.esprit.tp_foyer.Repositories.ReservationRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;

    public List<ReservationDTO> retrieveAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationServiceImpl::convertToDto)
                .collect(Collectors.toList());
    }

    public Reservation retrieveReservation(String reservationId) {
        return reservationRepository.findById(reservationId).get();
    }

    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    public void removeReservation(String reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public static Set<ReservationDTO> convertToDtoSet(Set<Reservation> reservations) {
        if (reservations == null) return Set.of();
        return reservations.stream()
                .map(ReservationServiceImpl::convertToDto)
                .collect(Collectors.toSet());
    }

    public static ReservationDTO convertToDto(Reservation reservation) {
        if (reservation == null) return null;

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setAnneeUniversitaire(reservation.getAnneeUniversitaire()); // or reservationDate if that's what it really represents
        reservationDTO.setEstValide(reservation.isEstValide());

        // Convert the associated Etudiants
        reservationDTO.setEtudiants(
                EtudiantServiceImpl.convertToDtoSet(reservation.getEtudiants())
        );

        return reservationDTO;
    }
}

