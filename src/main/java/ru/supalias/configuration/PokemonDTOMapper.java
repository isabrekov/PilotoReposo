package ru.supalias.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.supalias.model.buisness.PokemonDTO;
import ru.supalias.model.database.PokemonForDB;

@Mapper
public interface PokemonDTOMapper {
    PokemonDTOMapper INSTANCE = Mappers.getMapper( PokemonDTOMapper.class );
    PokemonForDB pokemonDTOToPokemonForDB(PokemonDTO pokemonDTO);
}
