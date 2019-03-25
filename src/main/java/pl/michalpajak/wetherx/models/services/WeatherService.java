package pl.michalpajak.wetherx.models.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.michalpajak.wetherx.models.WeatherDto;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    public WeatherDto getCurrentWeather(String cityName) {
        Map<String, String> urlVars = new HashMap<>();
        urlVars.put("q", cityName);
        urlVars.put("appid", "e9fcb4a9a22e01907b6742a720b67145");
        urlVars.put("units", "metric");

        WeatherDto weatherDto = getRestTemplate().getForObject("http://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}&units={units}",
                WeatherDto.class,
                urlVars);

        return weatherDto;
    }

    public WeatherDto getForecastWeather(String cityName) {
        Map<String, String> urlVars = new HashMap<>();
        urlVars.put("q", cityName);
        urlVars.put("appid", "e9fcb4a9a22e01907b6742a720b67145");
        urlVars.put("units", "metric");

        WeatherDto weatherDto = getRestTemplate().getForObject("http://api.openweathermap.org/data/2.5/forecast?q={q}&appid={appid}&units={units}",
                WeatherDto.class,
                urlVars);

        return weatherDto;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
