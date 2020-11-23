package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.tools.Tool;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDay {
    @JsonProperty(value="Rep")
    private ForecastBlock[] forecastBlocks;
    private Date date;

    @JsonProperty(value="value")
    private void convertDate (String dateAsString){
        try {
            String trimmedDate = dateAsString.substring(0, dateAsString.length() - 1);
            date = new SimpleDateFormat("yyyy-MM-dd").parse(trimmedDate);
        }catch(ParseException p){
            System.out.println(Toolkit.redText("INVALID DATE"));
        }
    }

    public ForecastBlock[] getForecastBlocks() {
        return forecastBlocks;
    }

    public Date getDate() {
        return date;
    }

    public void display(){
        System.out.println(Toolkit.redText(Toolkit.showDateOnly(date)));
        for(ForecastBlock block : forecastBlocks){
            //block.display();
            System.out.println("Time and Data");
        }
    }
}
