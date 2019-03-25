package pl.michalpajak.wetherx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.michalpajak.wetherx.models.services.WeatherService;

@Controller
public class MainController {

    final WeatherService weatherService;

    @Autowired
    public MainController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String weather() {

        return "weather_view";
    }

    @PostMapping("/")
    public String weather(@RequestParam("city") String city, Model model) {

        model.addAttribute("weather", weatherService.getCurrentWeather(city));
        model.addAttribute("averageTemperature", weatherService.getAverageTemperature(weatherService.getForecastWeather(city)));

        return "weather_view";
    }


}
