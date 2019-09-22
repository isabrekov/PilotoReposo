package ru.supalias.model.buisness;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class AbilityEffectDTO {
    @JsonProperty("short_effect")
    private String shortEffect;
}
