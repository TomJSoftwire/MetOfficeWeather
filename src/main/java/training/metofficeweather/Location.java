package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Comparable<Location> {
    @JsonProperty
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String unitaryAuthArea;

    public void display() {
        System.out.println(Toolkit.greenText(name) + ", " + unitaryAuthArea);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getUnitaryAuthArea() {
        if (unitaryAuthArea == null) {
            return "Other";
        }
        return unitaryAuthArea;
    }

    @Override
    public int compareTo(Location location) {
        return name.compareTo(location.getName());
    }
}
