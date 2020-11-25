package training.metofficeweather;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class APIHandler {
    private final String key = getKey();
    private final WebTarget webTarget = getDefaultTarget();

    public APIHandler() {
    }

    private String getKey() {
        System.out.println(System.getenv("KEY"));
        return System.getenv("KEY").replace("_", "-");
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
        return getForecast(locationId);

    }

    public Forecast getForecast(String locationId){
        Response response = webTarget.path(locationId)
                .queryParam("res","3hourly")
                .queryParam("key", key)
                .request()
                .get();
        Forecast forecast = response.readEntity(Forecast.class);
        return forecast;
    }
}
