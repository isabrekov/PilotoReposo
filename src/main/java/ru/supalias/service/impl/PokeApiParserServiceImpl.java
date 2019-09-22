package ru.supalias.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.supalias.model.buisness.AbilityListDTO;
import ru.supalias.model.buisness.PokemonsListDTO;
import ru.supalias.service.PokeApiParserSecvice;

import java.io.IOException;
import java.net.URL;

@Service("PokeApiParserService")
public class PokeApiParserServiceImpl implements PokeApiParserSecvice {

    @Autowired
    ObjectMapper objectMapper;

    public PokemonsListDTO parsePokeApi() throws IOException {
        URL url = new URL("https://pokeapi.co/api/v2/pokemon");
        PokemonsListDTO pokemonsListDTO = objectMapper.readValue(url, PokemonsListDTO.class);
        for (int i = 0; i < pokemonsListDTO.getPokemonDTOList().size(); i++) {
            url = pokemonsListDTO.getPokemonDTOList().get(i).getUrl();
            pokemonsListDTO.getPokemonDTOList().get(i).setAbilityListDTO(objectMapper.readValue(url, AbilityListDTO.class));
        }
        return pokemonsListDTO;
    }
}
