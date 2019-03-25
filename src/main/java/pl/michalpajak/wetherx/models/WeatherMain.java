package pl.michalpajak.wetherx.models;

import lombok.Data;

@Data
public class WeatherMain {

    private double temp;
    private int pressure;
    private int humidity;

    public double getTempInCelsiusDegrees() {
//        return ((this.temp - 32.0) / 1.8);
        return this.temp - 273.15;
    }
}
