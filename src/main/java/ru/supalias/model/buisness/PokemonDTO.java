package ru.supalias.model.buisness;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class PokemonDTO{
    private String name;
    private URL url;
    private AbilityListDTO abilityListDTO;
}
