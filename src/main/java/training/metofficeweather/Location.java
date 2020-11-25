package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.tools.Tool;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
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

}
