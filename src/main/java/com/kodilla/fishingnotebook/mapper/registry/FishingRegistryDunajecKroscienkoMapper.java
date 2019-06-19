package com.kodilla.fishingnotebook.mapper.registry;

import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistryDto;
import org.springframework.stereotype.Component;

@Component
public class FishingRegistryDunajecKroscienkoMapper {

    public DunajecKroscienkoRegistryDto mapToDunajecKroscienkoDto(final DunajecKroscienkoRegistry dunajecKroscienkoRegistry) {
        return new DunajecKroscienkoRegistryDto(
                dunajecKroscienkoRegistry.getId(),
                dunajecKroscienkoRegistry.getCatchDate(),
                dunajecKroscienkoRegistry.getFishType(),
                dunajecKroscienkoRegistry.getLength(),
                dunajecKroscienkoRegistry.getQty());
    }

    public DunajecKroscienkoRegistry mapToDunajecKroscienko(final DunajecKroscienkoRegistryDto dunajecKroscienkoRegistryDto) {
        return new DunajecKroscienkoRegistry(
                dunajecKroscienkoRegistryDto.getId(),
                dunajecKroscienkoRegistryDto.getCatchDate(),
                dunajecKroscienkoRegistryDto.getFishType(),
                dunajecKroscienkoRegistryDto.getLength(),
                dunajecKroscienkoRegistryDto.getQty());
    }
}
