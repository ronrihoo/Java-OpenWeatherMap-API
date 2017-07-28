package owmapi;

public class Constants {

    public static final String URL_BASE = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String URL_ZIPCODE = "?zip=";
    public static final String URL_UNITS = "&units=";
    public static final String URL_APP_ID = "&appid=";
    public static final String URL_COMMA = ",";

    public static final String REPORT_FORECAST_FOR = "Weather forecast for ";
    public static final String REPORT_CITY = " city: ";
    public static final String REPORT_SKY = " sky";
    public static final String REPORT_TEMP = " and a temperature of ";
    public static final String REPORT_HIGH = " with a high of ";
    public static final String REPORT_LOW = " and a low of ";

    public static final String UNITS_FAHRENHEIT = "imperial";
    public static final String UNITS_CELSIUS = "metric";
    public static final String UNITS_KELVIN = "default";

    public static final String DEGREES_FAHRENHEIT = "°F";
    public static final String DEGREES_CELSIUS = "°C";
    public static final String KELVIN = "K";

    public static final String DEFAULT_CITY = "Richardson";
    public static final String DEFAULT_STATE = "TX";
    public static final String DEFAULT_COUNTRY = "US";
    public static final String DEFAULT_UNITS = UNITS_FAHRENHEIT;    // imperial

    public static final String ZIPCODE_PATTERN = "(^[0-9]{5}(-?)((?:-[0-9]{4})?)*$)";
    public static final String NUMERIC_PATTERN = "^*[0-9]{5,}.*$";

}
