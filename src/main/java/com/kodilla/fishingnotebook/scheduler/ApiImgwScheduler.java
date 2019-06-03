package com.kodilla.fishingnotebook.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApiImgwScheduler {

    @Autowired
    private HttpGetRequesToApi httpGetRequesToApi;

    //@Scheduled(fixedDelay = 60000)
    public void sendGet() throws Exception {
        httpGetRequesToApi.sendGetToImgw();
        httpGetRequesToApi.sendGetToAccuweatherLesko();
        httpGetRequesToApi.sendGetToAccuweatherKroscienko();
        httpGetRequesToApi.sendGetToAccuweatherGolkowice();
    }
}
