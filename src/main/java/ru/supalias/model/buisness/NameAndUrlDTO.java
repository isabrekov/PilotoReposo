package ru.supalias.model.buisness;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class NameAndUrlDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private URL url;
}
