package ru.supalias.model.buisness;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class AbilityDTO {
//    private String name;
//    private URL url;
    @JsonProperty("ability")
    private NameAndUrlDTO nameAndUrlDTO;
    private AbilityEffectListDTO abilityEffectListDTO;
}
