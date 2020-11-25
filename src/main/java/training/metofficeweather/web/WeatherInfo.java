package training.metofficeweather.web;

import training.metofficeweather.APIHandler;
import training.metofficeweather.Forecast;

public class WeatherInfo {
    private final String locationId;
    private final Forecast forecast;

    public WeatherInfo(String locationId, APIHandler api) {
        this.locationId = locationId;
        forecast = api.getForecast(locationId);
    }

    public String getLocationId() {
        return locationId;
    }

    public Forecast getForecast() {
        return forecast;
    }
}
