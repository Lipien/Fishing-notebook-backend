package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.service.DbServiceFacade;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HydroAndWeatherController.class)
public class HydroAndWeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbServiceFacade dbServiceFacade;

    @Test
    public void getFishingCondistionsReport() throws Exception {
        //Given
        List <String> reportLesko = new ArrayList <>();
        reportLesko.add("The water status of the San River is 180 cm. Weather nice.");
        when(dbServiceFacade.getWeatherAndHydroReport()).thenReturn(reportLesko);

        //When & Then
        mockMvc.perform((get("/v1/report/getFishingConditionsReport").contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
