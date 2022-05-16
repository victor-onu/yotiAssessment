package com.example.yotiassessment.controller;

import com.example.yotiassessment.dto.RoboticHooverInputDTO;
import com.example.yotiassessment.model.RoboticHooverInput;
import com.example.yotiassessment.repository.RoboticHooverInputRepository;
import com.example.yotiassessment.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class RoboticHooverControllerTest {

    private String path = "/api/clean-patches";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RoboticHooverInputRepository roboticHooverInputRepository;



    @BeforeEach
    public void setUpBeforeEach() {
        roboticHooverInputRepository.deleteAll();
    }

    @AfterEach
    public void setUpAfterEach() {
        roboticHooverInputRepository.deleteAll();
    }

    @Test
    void findHooverPositionAndDirtCleaned() throws Exception {
        int databaseSizeBeforeCreate = roboticHooverInputRepository.findAll().size();

        RoboticHooverInputDTO roboticHooverInputDTO = new RoboticHooverInputDTO();
        roboticHooverInputDTO.setCoords(List.of(1,2));
        roboticHooverInputDTO.setRoomSize(List.of(5,5));
        roboticHooverInputDTO.setInstructions("NNESEESWNWW");
        roboticHooverInputDTO.setPatches(List.of(List.of(1, 0),List.of(2, 2), List.of(2, 3)));

        mockMvc
                .perform(post(path).contentType(MediaType.APPLICATION_JSON).content(TestUtils.asJsonString(roboticHooverInputDTO)))
                .andExpect(status().isOk());

        List<RoboticHooverInput> roboticHooverInputList = roboticHooverInputRepository.findAll();
        assertThat(roboticHooverInputList).hasSize(databaseSizeBeforeCreate + 1);

        RoboticHooverInput testRoboticHooverInput = roboticHooverInputList.get(roboticHooverInputList.size() - 1);
        assertThat(testRoboticHooverInput.getRoboticHooverOutPut().getPatches()).isEqualTo(1);
        assertThat(testRoboticHooverInput.getRoboticHooverOutPut().getCoords().get(0)).isEqualTo(1);
        assertThat(testRoboticHooverInput.getRoboticHooverOutPut().getCoords().get(1)).isEqualTo(3);
    }

    @Test
    void findHooverPositionAndDirtCleanedWithNullValuesInRequest() throws Exception {

        RoboticHooverInputDTO roboticHooverInputDTO = new RoboticHooverInputDTO();

        roboticHooverInputDTO.setRoomSize(List.of(5,5));
        roboticHooverInputDTO.setInstructions("NNESEESWNWW");
        roboticHooverInputDTO.setPatches(List.of(List.of(1, 0),List.of(2, 2), List.of(2, 3)));

        mockMvc
                .perform(post(path).contentType(MediaType.APPLICATION_JSON).content(TestUtils.asJsonString(roboticHooverInputDTO)))
                .andExpect(status().isBadRequest());

    }
}