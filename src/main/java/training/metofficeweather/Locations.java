package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations {
    @JsonProperty(value="Location")
    private ArrayList<Location> locationList;

    public void printAll() {
        for (Location location: locationList) {
            location.display();
        }
    }
    public Location searchByName(String name) {
        for (Location location: locationList) {
            if (location.getName().equalsIgnoreCase(name)) {
                return location;
            }
        }
        return null;
    }
}
