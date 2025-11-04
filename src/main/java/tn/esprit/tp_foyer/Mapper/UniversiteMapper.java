package tn.esprit.tp_foyer.Mapper;

import org.mapstruct.Mapper;
import tn.esprit.tp_foyer.DTO.UniversiteDTO;
import tn.esprit.tp_foyer.Entities.Universite;

@Mapper(componentModel = "spring")
public interface UniversiteMapper {
    UniversiteDTO toDto(Universite universite);
}
