package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistryDto;
import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistry;
import com.kodilla.fishingnotebook.mapper.registry.FishingRegistryDunajecKroscienkoMapper;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistryDunajecKroscienkoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/registry")
public class FishinRegistryDunajecKroscienkoController {

    @Autowired
    DbServiceFishingRegistryDunajecKroscienkoRepository dbServiceFishingRegistryDunajecKroscienkoRepository;

    @Autowired
    FishingRegistryDunajecKroscienkoMapper fishingRegistryDunajecKroscienkoMapper;

    @GetMapping(value = "getDunajecKroscienkoRegistry")
    public List <DunajecKroscienkoRegistry> getDunajecKroscienkoRegistry() {
        return dbServiceFishingRegistryDunajecKroscienkoRepository.getAllFish();
    }

    @PostMapping(value = "createDunajecKroscienkoRegistry")
    public void createDunajecKroscienkoRegistry(@RequestBody DunajecKroscienkoRegistryDto dunajecKroscienkoRegistryDto) {
        dbServiceFishingRegistryDunajecKroscienkoRepository.saveFish(fishingRegistryDunajecKroscienkoMapper.mapToDunajecKroscienko(dunajecKroscienkoRegistryDto));
    }

    @DeleteMapping(value = "deleteDunajecKroscienkoRegistry")
    public void deleteDunajecKroscienkoRegistry(@RequestParam Long id) {
        dbServiceFishingRegistryDunajecKroscienkoRepository.deleteFish(id);
    }
}
