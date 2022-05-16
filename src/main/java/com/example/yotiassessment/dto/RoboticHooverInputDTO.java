package com.example.yotiassessment.dto;

import com.example.yotiassessment.model.RoboticHooverOutPut;
import lombok.Data;

import javax.validation.constraints.NotNull;

import java.util.List;

@Data
public class RoboticHooverInputDTO {

    @NotNull
    private List<Integer> roomSize;

    @NotNull
    private List<Integer> coords;

    @NotNull
    private List<List<Integer>> patches;

    private RoboticHooverOutPut roboticHooverOutPut;

    @NotNull
    private String instructions;
}
