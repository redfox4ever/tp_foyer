package tn.esprit.tp_foyer.Mapper;

import org.mapstruct.Mapper;
import tn.esprit.tp_foyer.DTO.ChambreDTO;
import tn.esprit.tp_foyer.Entities.Chambre;

@Mapper(componentModel = "spring")
public interface ChambreMapper {
    ChambreDTO toDto(Chambre chambre);
}
