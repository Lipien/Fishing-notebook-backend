package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistry;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistryDunajecKroscienkoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/registry")
public class FishinRegistryDunajecKroscienkoController {

    @Autowired
    DbServiceFishingRegistryDunajecKroscienkoRepository dbServiceFishingRegistryDunajecKroscienkoRepository;

    @GetMapping(value = "getDunajecKroscienkoRegistry")
    public List <DunajecKroscienkoRegistry> getDunajecKroscienkoRegistry() {
        return dbServiceFishingRegistryDunajecKroscienkoRepository.getAllFish();
    }
}
