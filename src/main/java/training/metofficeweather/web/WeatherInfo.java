package training.metofficeweather.web;

import training.metofficeweather.APIHandler;
import training.metofficeweather.Forecast;

public class WeatherInfo {
    private final String locationId;
    private final Forecast forecast;
    private final String locationName;

    public WeatherInfo(String locationId, APIHandler api) {
        this.locationId = locationId;
        forecast = api.getForecast(locationId);
        locationName = forecast.getForecastLocation();
    }

    public String getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public Forecast getForecast() {
        return forecast;
    }
}
