package com.kodilla.fishingnotebook.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApiImgwScheduler {

    @Autowired
    private ImgwHttpGetRequest imgwHttpGetRequest;

   // @Scheduled(fixedDelay = 60000)
    public void sendGet() throws Exception {
        imgwHttpGetRequest.sendGetToHydro();
    }
}
