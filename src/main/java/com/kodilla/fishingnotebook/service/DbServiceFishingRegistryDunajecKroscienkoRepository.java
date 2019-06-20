package com.kodilla.fishingnotebook.service;

import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistry;
import com.kodilla.fishingnotebook.repository.registryrepositories.RegistryDunajecKroscienkoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DbServiceFishingRegistryDunajecKroscienkoRepository {

    @Autowired
    private RegistryDunajecKroscienkoRepository registryDunajecKroscienkoRepository;

    public List <DunajecKroscienkoRegistry> getAllFish() {
        return registryDunajecKroscienkoRepository.findAll();
    }

    public DunajecKroscienkoRegistry saveFish(final DunajecKroscienkoRegistry dunajecKroscienkoRegistry) {
        return registryDunajecKroscienkoRepository.save(dunajecKroscienkoRegistry);
    }

    public void deleteFish(Long id) {
        registryDunajecKroscienkoRepository.deleteById(id);
    }

    public DunajecKroscienkoRegistry updateFish(final DunajecKroscienkoRegistry dunajecKroscienkoRegistry) {
        return registryDunajecKroscienkoRepository.save(dunajecKroscienkoRegistry);
    }
}
