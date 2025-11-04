package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.Entities.Reservation;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(String reservationId);
    Reservation addReservation(Reservation r);
    void removeReservation(String reservationId);
    Reservation modifyReservation(Reservation reservation);
}

