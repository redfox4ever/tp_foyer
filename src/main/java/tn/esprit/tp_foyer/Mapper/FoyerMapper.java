package tn.esprit.tp_foyer.Mapper;

import org.mapstruct.Mapper;
import tn.esprit.tp_foyer.DTO.FoyerDTO;
import tn.esprit.tp_foyer.Entities.Foyer;

@Mapper(componentModel = "spring")
public interface FoyerMapper {
    FoyerDTO toDto(Foyer foyer);
}
