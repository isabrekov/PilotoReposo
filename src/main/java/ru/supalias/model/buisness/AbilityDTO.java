package ru.supalias.model.buisness;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class AbilityDTO {
    private String name;
    private URL url;
    private AbilityEffectDTO abilityEffectDTO;
}
