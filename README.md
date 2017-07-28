# A light OpenWeatherMap API for Java

[![Release](https://img.shields.io/github/release/ronrihoo/Java-OpenWeatherMap-API/all.svg)](https://github.com/ronrihoo/Java-OpenWeatherMap-API/releases)

An OpenWeatherMap API for Java.

## Setup

1. Either build the JAR or download it from the latest [release](https://github.com/ronrihoo/Java-OpenWeatherMap-API/releases)

2. Create a folder, "lib", in the directory of a new/existing project

3. Move or copy the JAR file into the _lib_ folder

4. Add the JAR file to the build path

   IDEA: From the _Project_ window, select and right-click the _lib_ folder, then click **Add as Library...**

   Eclipse: From the _Package Explorer_, select and right-click the JAR file, then select **Build** and click **Add to Build Path**

## Usage

1. In a Java source file, import the OpenWeatherMap API

```java
import owmapi.OwmApi;
```

2. Create an instance of the API

```java
OwmApi owmApi = new OwmApi();
```

3. Set the OpenWeatherMap App ID by passing it as a string

```java
owmApi.setAppId("OWM-App-ID-Here");
```

4. Get weather report based on zipcode

```java
String weatherReport = owmApi.runWithZipcode("75080-3021");
```

## A Complete Example

```java
import owmapi.OwmApi;

public class Main {

    public static void main(String[] args) {
        run("OWM-App-ID-Here", "75080-3021");
    }

    public static void run(String appId, String zipcode) {
        OwmApi owmApi = new OwmApi();
        owmApi.setAppId(appId);
        String weatherReport = owmApi.runWithZipcode(zipcode);
        if (weatherReport != null) {
            System.out.println(weatherReport);
        }
    }

}
```

Result:

```
Weather forecast for Richardson city: cloudy and a temperature of 80.9 with a high of 84.2 and a low of 77.0
```

## API Reference

`setAppId(String)`

&nbsp;&nbsp;&nbsp;&nbsp;Sets the OpenWeatherMap App ID for retrieving data from the web API

`runWithZip(String)`

&nbsp;&nbsp;&nbsp;&nbsp;Runs the Java OpenWeatherMap API using zip code information

Note: This API includes more methods; however, this covers the majority of its functionality at this time.

## Contributing

All pull requests are welcome.