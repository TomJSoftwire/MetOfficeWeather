package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public void display() {
        String title = String.format("%02d:%02d %s", minutes / 60, minutes % 60, Toolkit.getWeatherCode(weatherCode));
        System.out.println(Toolkit.blueBoldText(title));
        System.out.println("Temperature of " + temperature + " degrees Centigrade");
        System.out.println("Feels like " + feelsLike + " degrees Centigrade");
        System.out.println(precipitationProbability + "% chance of rain\n");
    }
}
