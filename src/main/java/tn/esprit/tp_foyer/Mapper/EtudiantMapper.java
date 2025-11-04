package tn.esprit.tp_foyer.Mapper;

import org.mapstruct.Mapper;
import tn.esprit.tp_foyer.DTO.EtudiantDTO;
import tn.esprit.tp_foyer.Entities.Etudiant;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    EtudiantDTO toDto(Etudiant etudiant);
}
