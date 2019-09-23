package ru.supalias.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.supalias.configuration.AbilityDTOMapper;
import ru.supalias.configuration.PokemonDTOMapper;
import ru.supalias.model.buisness.AbilityEffectListDTO;
import ru.supalias.model.buisness.AbilityListDTO;
import ru.supalias.model.buisness.PokemonListDTO;
import ru.supalias.model.database.AbilityForDB;
import ru.supalias.model.database.PokemonForDB;
import ru.supalias.service.PokeApiParserSecvice;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Service("PokeApiParserService")
public class PokeApiParserServiceImpl implements PokeApiParserSecvice {

    @Autowired
    ObjectMapper objectMapper;

    public PokemonListDTO parsePokeApi() throws IOException {
        URL url = new URL("https://pokeapi.co/api/v2/pokemon");
        PokemonListDTO pokemonListDTO = objectMapper.readValue(url, PokemonListDTO.class);
        for (int i = 0; i < pokemonListDTO.getPokemonDTOList().size(); i++) {
            url = pokemonListDTO.getPokemonDTOList().get(i).getUrl();
            pokemonListDTO.getPokemonDTOList().get(i).setAbilityListDTO(objectMapper.readValue(url, AbilityListDTO.class));
                for (int j = 0; j < pokemonListDTO.getPokemonDTOList().get(i).getAbilityListDTO().getAbilityDTOList().size(); j++){
                    url = pokemonListDTO.getPokemonDTOList().get(i).getAbilityListDTO().getAbilityDTOList().get(j).getNameAndUrlDTO().getUrl();
                    pokemonListDTO.getPokemonDTOList().get(i).getAbilityListDTO().getAbilityDTOList().get(j).setAbilityEffectListDTO(objectMapper.readValue(url, AbilityEffectListDTO.class));

                }
        }
        return pokemonListDTO;
    }

    public void convertPoke(PokemonListDTO pokemonListDTO) throws IOException {
        List<PokemonForDB> pokemonForDBList = new LinkedList<>();
        PokemonForDB pokemonForDB = new PokemonForDB();
        List<AbilityForDB> abilityForDBList = new LinkedList<>();
        AbilityForDB abilityForDB = new AbilityForDB();
        for(int i = 0; i < pokemonListDTO.getPokemonDTOList().size(); i++) {
            pokemonForDB = PokemonDTOMapper.INSTANCE.pokemonDTOToPokemonForDB(pokemonListDTO.getPokemonDTOList().get(i));
            for(int j = 0; j < pokemonListDTO.getPokemonDTOList().get(i).getAbilityListDTO().getAbilityDTOList().size(); j++) {
                abilityForDB = AbilityDTOMapper.INSTANCE.abilityDTOToAbilityForDB(pokemonListDTO.getPokemonDTOList().get(i).getAbilityListDTO().getAbilityDTOList().get(j));
                abilityForDBList.add(abilityForDB);
            }
            pokemonForDB.setAbilityForDBList(abilityForDBList);
            pokemonForDBList.add(pokemonForDB);
        }
    }
}
