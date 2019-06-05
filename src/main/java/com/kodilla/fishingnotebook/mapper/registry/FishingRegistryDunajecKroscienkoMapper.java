package com.kodilla.fishingnotebook.mapper.registry;

import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FishingRegistryDunajecKroscienkoMapper {

    public List <DunajecKroscienkoRegistryDto> mapToDunajecKroscienkoDtoList(final List <DunajecKroscienkoRegistry> dunajecKroscienkoRegistryList) {
        return dunajecKroscienkoRegistryList.stream()
                .map(t -> new DunajecKroscienkoRegistryDto(t.getId(), t.getCatchDate(), t.getFishType(), t.getLength(), t.getQty()))
                .collect(Collectors.toList());
    }

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
