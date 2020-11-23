package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations {
    @JsonProperty(value="Location")
    private ArrayList<Location> locationList;
    public Location getFirst(){
        return locationList.get(0);
    }
    public void printAll() {
        for (Location location: locationList) {
            location.display();
        }
    }
}
