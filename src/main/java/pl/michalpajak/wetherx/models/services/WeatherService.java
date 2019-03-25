package pl.michalpajak.wetherx.models.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.michalpajak.wetherx.models.WeatherDto;
import pl.michalpajak.wetherx.models.WeatherDtoList;

import java.util.HashMap;
import java.util.List;
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

    public WeatherDtoList getForecastWeather(String cityName) {
        Map<String, String> urlVars = new HashMap<>();
        urlVars.put("q", cityName);
        urlVars.put("appid", "e9fcb4a9a22e01907b6742a720b67145");
        urlVars.put("units", "metric");

        WeatherDtoList weatherDtoList = getRestTemplate().getForObject("http://api.openweathermap.org/data/2.5/forecast?q={q}&appid={appid}&units={units}",
                WeatherDtoList.class,
                urlVars);

        return weatherDtoList;
    }

    public double getAverageTemperature(WeatherDtoList weatherDtoList) {
        double result = 0;
        List<WeatherDto> fiveDayWeatherList = weatherDtoList.getFiveDayWeatherList();

        for (WeatherDto weatherDto:fiveDayWeatherList) {
            result += weatherDto.getMainData().getTemp();
        }

        return result / fiveDayWeatherList.size();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
