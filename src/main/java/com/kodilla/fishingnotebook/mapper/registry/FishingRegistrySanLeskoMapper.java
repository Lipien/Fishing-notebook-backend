package com.kodilla.fishingnotebook.mapper.registry;

import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistry;
import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FishingRegistrySanLeskoMapper {

    public List <SanLeskoRegistryDto> mapToSanLeskoDtoList(final List <SanLeskoRegistry> sanLeskoRegistryList) {
        return sanLeskoRegistryList.stream()
                .map(t -> new SanLeskoRegistryDto(t.getId(), t.getCatchDate(), t.getFishType(), t.getLength(), t.getQty()))
                .collect(Collectors.toList());
    }

    public SanLeskoRegistryDto mapToSanLeskoDto(final SanLeskoRegistry sanLeskoRegistry) {
        return new SanLeskoRegistryDto(
                sanLeskoRegistry.getId(),
                sanLeskoRegistry.getCatchDate(),
                sanLeskoRegistry.getFishType(),
                sanLeskoRegistry.getLength(),
                sanLeskoRegistry.getQty());
    }

    public SanLeskoRegistry mapToSanLesko(final SanLeskoRegistryDto sanLeskoRegistryDto) {
        return new SanLeskoRegistry(
                sanLeskoRegistryDto.getId(),
                sanLeskoRegistryDto.getCatchDate(),
                sanLeskoRegistryDto.getFishType(),
                sanLeskoRegistryDto.getLength(),
                sanLeskoRegistryDto.getQty());
    }
}