package training.metofficeweather;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        APIHandler api = new APIHandler();
        Scanner scan = new Scanner(System.in);

        System.out.println("Getting available locations... \n");
        Locations locations = api.getLocations();
        locations.printAll();
        interact(scan, locations);
    }

    public static void interact(Scanner scan, Locations locations) {
        boolean running = true;
        while (running) {
            System.out.println("Please enter the name of a location, all to display all, or exit to quit");
            String name = scan.nextLine();
            Location location = locations.searchByName(name);
            if (name.equalsIgnoreCase("quit")) {
                running = false;
            } else if (name.equalsIgnoreCase("all")) {
                locations.printAll();
            } else if (location != null) {
                System.out.println(location.getId()); // Will need to add processing here.
            } else {
                System.out.println("Please enter a valid location. Enter ALL for the list again.");
            }
        }
    }
}	
