package training.metofficeweather.web;

import training.metofficeweather.Location;
import training.metofficeweather.Locations;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class GroupedLocations {

    private Map<String, List<Location>> locationsByAuthArea;

    public GroupedLocations(Locations locations) {
        locationsByAuthArea =
                locations.getLocationList()
                        .stream()
                        .collect(groupingBy(Location::getUnitaryAuthArea));
    }

    private Set<String> getAuthAreas() {
        return locationsByAuthArea.keySet();
    }

    private List<Location> getLocations(String authArea) {
        return locationsByAuthArea.get(authArea);
    }
}
