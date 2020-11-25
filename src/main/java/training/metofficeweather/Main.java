package training.metofficeweather;
import org.springframework.boot.SpringApplication;
import training.metofficeweather.web.Website;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        SpringApplication.run(Website.class, args);
        /**APIHandler api = new APIHandler();
        Scanner scan = new Scanner(System.in);

        System.out.println("Getting available locations... \n");
        Locations locations = api.getLocations();
        locations.printAll();
        interact(scan, locations, api);
         **/
    }

    public static void interact(Scanner scan, Locations locations, APIHandler api) {
        boolean running = true;
        while (running) {
            System.out.println("Please enter the name of a location, or help to display other options.");
            String name = scan.nextLine();
            Location location = locations.searchByName(name);
            if (name.equalsIgnoreCase("quit")) {
                running = false;
            } else if (name.equalsIgnoreCase("all")) {
                locations.printAll();
            } else if (name.equalsIgnoreCase("help")) {
                help();
            } else if (location != null) {
                Forecast forecast = api.getForecast(location);
                forecast.display();
            } else {
                System.out.println("The location was not found.");
            }
        }
    }

    public static void help() {
        System.out.println("Enter " + Toolkit.greenText("quit") + " to quit the application.");
        System.out.println("Enter " + Toolkit.greenText("all") + " to redisplay the list of locations.");
        System.out.println("Enter " + Toolkit.greenText("help") + " to redisplay this message.");
        System.out.println("Enter the name of a location to display the forecast for that location.");
        System.out.println("Note that only the name in green should be entered!\n");
    }
}	
