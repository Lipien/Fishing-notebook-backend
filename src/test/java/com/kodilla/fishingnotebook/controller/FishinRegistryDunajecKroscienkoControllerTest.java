package com.kodilla.fishingnotebook.controller;

import com.google.gson.Gson;
import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistryDto;
import com.kodilla.fishingnotebook.mapper.registry.FishingRegistryDunajecKroscienkoMapper;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistryDunajecKroscienkoRepository;
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
@WebMvcTest(FishinRegistryDunajecKroscienkoController.class)
public class FishinRegistryDunajecKroscienkoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbServiceFishingRegistryDunajecKroscienkoRepository dbServiceFishingRegistryDunajecKroscienkoRepository;

    @MockBean
    private FishingRegistryDunajecKroscienkoMapper fishingRegistryDunajecKroscienkoMapper;

    @Test
    public void getDunajecKroscienkoRegistry() throws Exception {
        //Given
        List <DunajecKroscienkoRegistry> dunajecKroscienkoRegistryList = new ArrayList <>();
        dunajecKroscienkoRegistryList.add(new DunajecKroscienkoRegistry(1L, "18-06-2019", "trout", "42", "1"));
        dunajecKroscienkoRegistryList.add(new DunajecKroscienkoRegistry(2L, "22-06-2019", "grayling", "35", "1"));

        when(dbServiceFishingRegistryDunajecKroscienkoRepository.getAllFish()).thenReturn(dunajecKroscienkoRegistryList);

        //When & Then
        mockMvc.perform((get("/v1/registry/getDunajecKroscienkoRegistry").contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getDunajecKroscienkoEmptyRegistry() throws Exception {
        //Given
        List <DunajecKroscienkoRegistry> dunajecKroscienkoRegistryList = new ArrayList <>();
        when(dbServiceFishingRegistryDunajecKroscienkoRepository.getAllFish()).thenReturn(dunajecKroscienkoRegistryList);

        //When & Then
        mockMvc.perform((get("/v1/registry/getDunajecKroscienkoRegistry").contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void createDunajecKroscienkoRegistry() throws Exception {
        //Given
        DunajecKroscienkoRegistryDto dunajecKroscienkoRegistryDto = new DunajecKroscienkoRegistryDto(11L, "18-06-2019", "trout", "34cm", "1");
        DunajecKroscienkoRegistry dunajecKroscienkoRegistry = new DunajecKroscienkoRegistry(11L, "18-06-2019", "trout", "34cm", "1");

        when(dbServiceFishingRegistryDunajecKroscienkoRepository.saveFish(any(DunajecKroscienkoRegistry.class))).thenReturn(dunajecKroscienkoRegistry);
        when(fishingRegistryDunajecKroscienkoMapper.mapToDunajecKroscienko(any(DunajecKroscienkoRegistryDto.class))).thenReturn(dunajecKroscienkoRegistry);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(dunajecKroscienkoRegistryDto);

        //When & Then
        mockMvc.perform(post("/v1/registry/createDunajecKroscienkoRegistry")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(dbServiceFishingRegistryDunajecKroscienkoRepository, times(1)).saveFish(any(DunajecKroscienkoRegistry.class));
    }

    @Test
    public void deleteDunajecKroscienkoRegistry() throws Exception {
        //When & Then
        mockMvc.perform(delete("/v1/registry/deleteDunajecKroscienkoRegistry?id=12")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateDunajecKroscienkoRegistry() throws Exception {
        //Given
        DunajecKroscienkoRegistryDto dunajecKroscienkoRegistryDto = new DunajecKroscienkoRegistryDto(11L, "18-06-2019", "trout", "34cm", "1");
        DunajecKroscienkoRegistry dunajecKroscienkoRegistry = new DunajecKroscienkoRegistry(11L, "18-06-2019", "trout", "34cm", "1");

        when(dbServiceFishingRegistryDunajecKroscienkoRepository.updateFish(any(DunajecKroscienkoRegistry.class))).thenReturn(dunajecKroscienkoRegistry);
        when(fishingRegistryDunajecKroscienkoMapper.mapToDunajecKroscienkoDto(any(DunajecKroscienkoRegistry.class))).thenReturn(dunajecKroscienkoRegistryDto);
        when(fishingRegistryDunajecKroscienkoMapper.mapToDunajecKroscienko(any(DunajecKroscienkoRegistryDto.class))).thenReturn(dunajecKroscienkoRegistry);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(dunajecKroscienkoRegistryDto);

        //When & Then
        mockMvc.perform(put("/v1/registry/updateDunajecKroscienkoRegistry")
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