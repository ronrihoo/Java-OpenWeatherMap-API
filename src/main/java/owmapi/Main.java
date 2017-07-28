package owmapi;

public class Main {

    public static void main(String[] args) {
        //test();
    }

    public static void test() {
        OwmApi owmApi = new OwmApi();
        // must uncomment the next line and set an app ID
        //owmApi.setAppId("");
        String weatherReport = owmApi.runWithZipcode("75080-3021");
        if (weatherReport != null) {
            System.out.println(weatherReport);
        }
    }

}