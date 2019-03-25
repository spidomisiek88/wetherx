package pl.michalpajak.wetherx.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {

    @JsonProperty("main")
    private WeatherMain mainData;
    @JsonProperty("clouds")
    private Clouds clouds;

}
