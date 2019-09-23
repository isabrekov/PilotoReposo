package ru.supalias.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.supalias.model.buisness.AbilityDTO;
import ru.supalias.model.database.AbilityForDB;

@Mapper
public interface AbilityDTOMapper {
    AbilityDTOMapper INSTANCE = Mappers.getMapper( AbilityDTOMapper.class );
    AbilityForDB abilityDTOToAbilityForDB(AbilityDTO pokemonDTO);
}
