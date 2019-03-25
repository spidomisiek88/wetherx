package pl.michalpajak.wetherx.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDtoList {

    @JsonProperty("list")
    private List<WeatherDto> fiveDayWeatherList;
}
