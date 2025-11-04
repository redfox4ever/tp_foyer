package tn.esprit.tp_foyer.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tp_foyer.DTO.BlocDTO;
import tn.esprit.tp_foyer.Entities.Bloc;

@Mapper(componentModel = "spring")
public interface BlocMapper {


    BlocDTO toDto(Bloc bloc);
}
