package pl.michalpajak.wetherx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String weather() {

        return "weather";
    }

    @PostMapping("/")
    public String weather(@RequestParam("city") String city) {

        return "weather";
    }
}
