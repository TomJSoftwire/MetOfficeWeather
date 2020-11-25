package training.metofficeweather.web;

import training.metofficeweather.Location;
import training.metofficeweather.Locations;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class GroupedLocations {

    private Map<String, List<Location>> locationsByAuthArea;

    public GroupedLocations(Locations locations) {
        locationsByAuthArea =
                locations.getLocationList()
                        .stream()
                        .collect(groupingBy(Location::getUnitaryAuthArea));
    }

    public List<String> getAuthAreas() {
        List<String> authList =  new ArrayList<>(locationsByAuthArea.keySet());
        Collections.sort(authList);
        return authList;
    }

    public List<Location> getLocations(String authArea) {
        List<Location> locations = locationsByAuthArea.get(authArea);
        Collections.sort(locations);
        return locations;
    }
}
