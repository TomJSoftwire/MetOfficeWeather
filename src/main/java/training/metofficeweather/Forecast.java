package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private ForecastDay[] forecastPeriod;
    private String forecastLocation;

    @SuppressWarnings("unchecked")
    @JsonProperty("SiteRep")
    private void unpackNested(Map<String,Object> siteRep){
        try {
            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> dv = (Map<String, Object>) siteRep.get("DV");
            Map<String, Object> location = (Map<String, Object>) dv.get("Location");

            forecastLocation = (String) location.get("name");

            String jsonArray = mapper.writeValueAsString(location.get("Period"));
            try {
                forecastPeriod =  mapper.readValue(jsonArray,ForecastDay[].class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(JsonProcessingException e){
            System.out.println("Unpack Function Error 1");
            e.printStackTrace();
        }
    }
    public void display(){
        System.out.println("Weather in " + Toolkit.greenText(forecastLocation) + " for the next 5 days.");
        for(ForecastDay day : forecastPeriod){
            day.display();
        }
    }
    public ForecastDay[] getForecastPeriod() {
        return forecastPeriod;
    }
}
