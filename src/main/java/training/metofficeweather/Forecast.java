package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    //@JsonProperty(value="Period")
    private ForecastDay[] forecastPeriod;

    @SuppressWarnings("unchecked")
    @JsonProperty("SiteRep")
    private void unpackNested(Map<String,Object> siteRep){
        try {
            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> dv = (Map<String, Object>) siteRep.get("DV");
            Map<String, Object> location = (Map<String, Object>) dv.get("Location");

            String jsonArray = mapper.writeValueAsString(location.get("Period"));
            forecastPeriod =  mapper.readValue(jsonArray,ForecastDay[].class);
        }catch(Exception e){
            System.out.println("Unpack Function Error 1");
            e.printStackTrace();
        }
    }

    public ForecastDay[] getForecastPeriod() {
        return forecastPeriod;
    }
}
