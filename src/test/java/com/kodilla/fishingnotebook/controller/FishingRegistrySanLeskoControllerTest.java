package com.kodilla.fishingnotebook.controller;

import com.google.gson.Gson;
import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistry;
import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistryDto;
import com.kodilla.fishingnotebook.mapper.registry.FishingRegistrySanLeskoMapper;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistrySanLeskoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FishingRegistrySanLeskoController.class)
public class FishingRegistrySanLeskoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbServiceFishingRegistrySanLeskoRepository dbServiceFishingRegistrySanLeskoRepository;

    @MockBean
    private FishingRegistrySanLeskoMapper fishingRegistrySanLeskoMapper;

    @Test
    public void getSanLeskoRegistry() throws Exception {
        //Given
        List <SanLeskoRegistry> sanLeskoRegistryList = new ArrayList <>();
        sanLeskoRegistryList.add(new SanLeskoRegistry(1L, "18-06-2019", "trout", "42", "1"));
        sanLeskoRegistryList.add(new SanLeskoRegistry(2L, "22-06-2019", "grayling", "35", "1"));

        when(dbServiceFishingRegistrySanLeskoRepository.getAllFish()).thenReturn(sanLeskoRegistryList);

        //When & Then
        mockMvc.perform((get("/v1/registry/getSanLeskoRegistry").contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getSanLeskoEmptyRegistry() throws Exception {
        //Given
        List <SanLeskoRegistry> sanLeskoRegistryList = new ArrayList <>();
        when(dbServiceFishingRegistrySanLeskoRepository.getAllFish()).thenReturn(sanLeskoRegistryList);

        //When & Then
        mockMvc.perform((get("/v1/registry/getSanLeskoRegistry").contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void createSanLeskoRegistry() throws Exception {
        //Given
        SanLeskoRegistryDto sanLeskoRegistryDto = new SanLeskoRegistryDto(11L, "18-06-2019", "trout", "34cm", "1");
        SanLeskoRegistry sanLeskoRegistry = new SanLeskoRegistry(11L, "18-06-2019", "trout", "34cm", "1");

        when(dbServiceFishingRegistrySanLeskoRepository.saveFish(any(SanLeskoRegistry.class))).thenReturn(sanLeskoRegistry);
        when(fishingRegistrySanLeskoMapper.mapToSanLesko(any(SanLeskoRegistryDto.class))).thenReturn(sanLeskoRegistry);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(sanLeskoRegistryDto);

        //When & Then
        mockMvc.perform(post("/v1/registry/createSanLeskoRegistry")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(dbServiceFishingRegistrySanLeskoRepository, times(1)).saveFish(any(SanLeskoRegistry.class));
    }

    @Test
    public void deleteSanLeskoRegistry() throws Exception {
        //When & Then
        mockMvc.perform(delete("/v1/registry/deleteSanLeskoRegistry?id=12")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateSanLeskoRegistry() throws Exception {
        //Given
        SanLeskoRegistryDto sanLeskoRegistryDto = new SanLeskoRegistryDto(11L, "18-06-2019", "trout", "34cm", "1");
        SanLeskoRegistry sanLeskoRegistry = new SanLeskoRegistry(11L, "18-06-2019", "trout", "34cm", "1");

        when(dbServiceFishingRegistrySanLeskoRepository.updateFish(any(SanLeskoRegistry.class))).thenReturn(sanLeskoRegistry);
        when(fishingRegistrySanLeskoMapper.mapToSanLeskoDto(any(SanLeskoRegistry.class))).thenReturn(sanLeskoRegistryDto);
        when(fishingRegistrySanLeskoMapper.mapToSanLesko(any(SanLeskoRegistryDto.class))).thenReturn(sanLeskoRegistry);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(sanLeskoRegistryDto);

        //When & Then
        mockMvc.perform(put("/v1/registry/updateSanLeskoRegistry")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(11)))
                .andExpect(jsonPath("$.catchDate", is("18-06-2019")))
                .andExpect(jsonPath("$.fishType", is("trout")))
                .andExpect(jsonPath("$.length", is("34cm")))
                .andExpect(jsonPath("$.qty", is("1")));
    }
}