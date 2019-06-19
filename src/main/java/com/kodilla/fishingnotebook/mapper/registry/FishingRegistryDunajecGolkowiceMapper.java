package com.kodilla.fishingnotebook.mapper.registry;

import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistryDto;
import org.springframework.stereotype.Component;

@Component
public class FishingRegistryDunajecGolkowiceMapper {

    public DunajecGolkowiceRegistryDto mapToDunajecGolkowiceDto(final DunajecGolkowiceRegistry dunajecGolkowiceRegistry) {
        return new DunajecGolkowiceRegistryDto(
                dunajecGolkowiceRegistry.getId(),
                dunajecGolkowiceRegistry.getCatchDate(),
                dunajecGolkowiceRegistry.getFishType(),
                dunajecGolkowiceRegistry.getLength(),
                dunajecGolkowiceRegistry.getQty());
    }

    public DunajecGolkowiceRegistry mapToDunajecGolkowice(final DunajecGolkowiceRegistryDto dunajecGolkowiceRegistryDto) {
        return new DunajecGolkowiceRegistry(
                dunajecGolkowiceRegistryDto.getId(),
                dunajecGolkowiceRegistryDto.getCatchDate(),
                dunajecGolkowiceRegistryDto.getFishType(),
                dunajecGolkowiceRegistryDto.getLength(),
                dunajecGolkowiceRegistryDto.getQty());
    }
}
