package tn.esprit.tp_foyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.Entities.Reservation;
import tn.esprit.tp_foyer.Repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;

    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
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
}

