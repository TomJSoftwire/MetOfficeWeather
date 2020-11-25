package training.metofficeweather;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIHandler {
    private final String key = getKey();
    private final WebTarget webTarget = getDefaultTarget();

    public APIHandler() throws IOException {
    }

    private String getKey() throws IOException {
        return Files.readAllLines(Paths.get("keys/key.txt")).get(0);
    }

    private WebTarget getDefaultTarget() {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        WebTarget webTarget = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json");
        webTarget.register(Root.class);
        return webTarget;
    }

    public Locations getLocations() {
        Response response = webTarget.path("sitelist").queryParam("key", key).request().get();
        Root root = response.readEntity(Root.class);
        return root.getLocations();
    }

    public Forecast getForecast(Location location){
        String locationId = location.getId();
        Response response = webTarget.path(locationId)
                .queryParam("res","3hourly")
                .queryParam("key", key)
                .request()
                .get();
        Forecast forecast = response.readEntity(Forecast.class);
        return forecast;
    }
}
