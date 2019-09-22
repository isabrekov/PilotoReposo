package ru.supalias.model.buisness;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class PokemonListDTO {
//    private int count;
//    private URL next;
//    private Object previous;
    @JsonProperty("results")
    List<PokemonDTO> pokemonDTOList;
}
