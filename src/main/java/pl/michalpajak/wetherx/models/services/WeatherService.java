package pl.michalpajak.wetherx.models.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.michalpajak.wetherx.models.WeatherDto;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    public WeatherDto getWeather(String cityName) {
        Map<String, String> urlVars = new HashMap<>();
        urlVars.put("q", cityName);
        urlVars.put("appid", "e9fcb4a9a22e01907b6742a720b67145");

        WeatherDto weatherDto = getRestTemplate().getForObject("api.openweathermap.org/data/2.5/weather",
                WeatherDto.class,
                urlVars);

        return weatherDto;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
