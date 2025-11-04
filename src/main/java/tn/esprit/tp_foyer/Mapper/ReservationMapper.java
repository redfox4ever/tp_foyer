package tn.esprit.tp_foyer.Mapper;

import org.mapstruct.Mapper;
import tn.esprit.tp_foyer.DTO.ReservationDTO;
import tn.esprit.tp_foyer.Entities.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationDTO toDto(Reservation reservation);
}
