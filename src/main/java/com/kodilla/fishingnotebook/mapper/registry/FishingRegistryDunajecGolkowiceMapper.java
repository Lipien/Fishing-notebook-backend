package com.kodilla.fishingnotebook.mapper.registry;

import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FishingRegistryDunajecGolkowiceMapper {

    public List <DunajecGolkowiceRegistryDto> mapToDunajecGolkowiceDtoList(final List <DunajecGolkowiceRegistry> dunajecGolkowiceRegistryList) {
        return dunajecGolkowiceRegistryList.stream()
                .map(t -> new DunajecGolkowiceRegistryDto(t.getId(), t.getCatchDate(), t.getFishType(), t.getLength(), t.getQty()))
                .collect(Collectors.toList());
    }

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
