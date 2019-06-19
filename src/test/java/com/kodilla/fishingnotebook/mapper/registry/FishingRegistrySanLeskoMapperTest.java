package com.kodilla.fishingnotebook.mapper.registry;

import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistry;
import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FishingRegistrySanLeskoMapperTest {

    @InjectMocks
    private FishingRegistrySanLeskoMapper fishingRegistrySanLeskoMapper;

    @Test
    public void mapToSanLeskoDto() {
        //Given
        SanLeskoRegistry sanLeskoRegistry = new SanLeskoRegistry(1L, "catchDate", "fishType", "length", "qty");

        //When
        SanLeskoRegistryDto resultingSanLeskoRegistryDto = fishingRegistrySanLeskoMapper.mapToSanLeskoDto(sanLeskoRegistry);

        //Then
        assertEquals(sanLeskoRegistry.getId(), resultingSanLeskoRegistryDto.getId());
        assertEquals(sanLeskoRegistry.getCatchDate(), resultingSanLeskoRegistryDto.getCatchDate());
        assertEquals(sanLeskoRegistry.getFishType(), resultingSanLeskoRegistryDto.getFishType());
        assertEquals(sanLeskoRegistry.getLength(), resultingSanLeskoRegistryDto.getLength());
        assertEquals(sanLeskoRegistry.getQty(), resultingSanLeskoRegistryDto.getQty());
    }

    @Test
    public void mapToSanLesko() {
        //Given
        SanLeskoRegistryDto sanLeskoRegistryDto = new SanLeskoRegistryDto(1L, "catchDate", "fishType", "length", "qty");

        //When
        SanLeskoRegistry resultingSanLeskoRegistry = fishingRegistrySanLeskoMapper.mapToSanLesko(sanLeskoRegistryDto);

        //Then
        assertEquals(sanLeskoRegistryDto.getId(), resultingSanLeskoRegistry.getId());
        assertEquals(sanLeskoRegistryDto.getCatchDate(), resultingSanLeskoRegistry.getCatchDate());
        assertEquals(sanLeskoRegistryDto.getFishType(), resultingSanLeskoRegistry.getFishType());
        assertEquals(sanLeskoRegistryDto.getLength(), resultingSanLeskoRegistry.getLength());
        assertEquals(sanLeskoRegistryDto.getQty(), resultingSanLeskoRegistry.getQty());
    }
}