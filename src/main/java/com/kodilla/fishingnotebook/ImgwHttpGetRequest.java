package com.kodilla.fishingnotebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ImgwHttpGetRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImgwHttpGetRequest.class);
    //@Value("${fishing.api.gethydro.httprequest}")
    //private static String imgwHttpGet;

    public static void sendGetToHydro() throws Exception {
        String url = "http://localhost:8080/v1/hydro/getHydro";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        LOGGER.info("'GET' request to URL : " + url + "  has been sent");
        LOGGER.info("Response Code : " + responseCode);
    }
}
