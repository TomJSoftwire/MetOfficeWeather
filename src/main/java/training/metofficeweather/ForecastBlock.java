package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.tools.Tool;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastBlock {
    @JsonProperty(value="W")
    private int weatherCode;

    @JsonProperty(value="T")
    private int temperature;

    @JsonProperty(value="F")
    private int feelsLike;

    @JsonProperty(value="Pp")
    private int precipitationProbability;

    @JsonProperty(value="$")
    private int minutes;

    public int getWeatherCode() {
        return weatherCode;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public int getPrecipitationProbability() {
        return precipitationProbability;
    }

    public int getMinutes() {
        return minutes;
    }
    public String getFormattedTime(){
        return String.format("%02d:%02d", minutes / 60, minutes % 60);
    }

    public void display() {
        String title = String.format("%02d:%02d %s", minutes / 60, minutes % 60, Toolkit.getWeatherCode(weatherCode));
        System.out.println(Toolkit.blueBoldText(title));
        System.out.println("Temperature of " + temperature + " degrees Centigrade");
        System.out.println("Feels like " + feelsLike + " degrees Centigrade");
        System.out.println(precipitationProbability + "% chance of rain\n");
    }
    public String displayWeatherType(){
        return Toolkit.getWeatherCode(weatherCode);
    }
    public String displayTemperature(){
        return  temperature + " °C";
    }
    public String displayFeelsLike(){
        return  feelsLike + " °C";
    }
    public String displayPrecipChance(){
        return precipitationProbability + " %";
    }
    public String getWeatherIcon(){
        String iconCode = Toolkit.weatherIconCodes.get(weatherCode);
        return "fas fa-3x " + iconCode;
    }
}
