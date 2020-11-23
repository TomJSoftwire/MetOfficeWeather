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

    public void display() {
        System.out.println(Toolkit.blueBoldText(Toolkit.getWeatherCode(weatherCode)));
        System.out.println("Temperature is " + temperature + " degrees Centigrade");
        System.out.println("Feels like " + feelsLike + " degrees Centigrade");
        System.out.println("Chance of rain is " + precipitationProbability + " %\n");
    }
}
