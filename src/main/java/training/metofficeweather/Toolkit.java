package training.metofficeweather;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Toolkit {
    private static List<String> weatherCodes = getCodes();

    public static String greenText(String text) {
        return "\u001b[32m" + text + "\u001b[0m";
    }

    public static String blueBoldText(String text) {
        return "\u001b[36m\u001b[1m" + text + "\u001b[0m\u001b[0m";
    }

    public static List<String> getCodes() {
        try {
            List<String> codes = Files.readAllLines(Path.of("Resources/WeatherTypeLookup.txt"));
            return codes;
        }
        catch (IOException e) {
            System.out.println("Error reading weather codes");
            return new ArrayList();
        }
    }

    public static String getWeatherCode(int code) {
        return weatherCodes.get(code);
    }
}
