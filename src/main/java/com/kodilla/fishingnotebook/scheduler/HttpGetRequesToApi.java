package com.kodilla.fishingnotebook.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpGetRequesToApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpGetRequesToApi.class);

    private String userAgent = "User-Agent";

    private String browser = "Mozilla/5.0";

    public void sendGetToImgw() throws Exception {
        String url = "http://localhost:8080/v1/hydro/getImgw";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty(userAgent, browser);
        int responseCode = connection.getResponseCode();
        LOGGER.info("'GET' request to URL IMGW : " + url + "  has been sent");
        LOGGER.info("Response Code : " + responseCode);
    }

    public void sendGetToAccuweatherLesko() throws Exception {
        String url = "http://localhost:8080/v1/accuweather/getWeatherLesko";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty(userAgent, browser);
        int responseCode = connection.getResponseCode();
        LOGGER.info("'GET' request to URL Lesko has been sent");
        LOGGER.info("Response Code : " + responseCode);
    }

    public void sendGetToAccuweatherKroscienko() throws Exception {
        String url = "http://localhost:8080/v1/accuweather/getWeatherKroscienko";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty(userAgent, browser);
        int responseCode = connection.getResponseCode();
        LOGGER.info("'GET' request to URL Kroscienko has been sent");
        LOGGER.info("Response Code : " + responseCode);
    }

    public void sendGetToAccuweatherGolkowice() throws Exception {
        String url = "http://localhost:8080/v1/accuweather/getWeatherGolkowice";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty(userAgent, browser);
        int responseCode = connection.getResponseCode();
        LOGGER.info("'GET' request to URL Golkowice has been sent");
        LOGGER.info("Response Code : " + responseCode);
    }
}
