package com.example.yotiassessment.controller;

import com.example.yotiassessment.apiresponse.ApiResponse;
import com.example.yotiassessment.dto.RoboticHooverInputDTO;
import com.example.yotiassessment.dto.RoboticHooverOutPutDTO;
import com.example.yotiassessment.model.RoboticHooverOutPut;
import com.example.yotiassessment.service.RoboticHooverService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RoboticHooverController {

    private final RoboticHooverService roboticHooverService;

    public RoboticHooverController(RoboticHooverService roboticHooverService) {
        this.roboticHooverService = roboticHooverService;
    }

    @PostMapping("/clean-patches")
    public ResponseEntity<ApiResponse<RoboticHooverOutPutDTO>> findHooverPositionAndDirtCleaned(@Valid @RequestBody RoboticHooverInputDTO roboticHooverInputDTO){
        RoboticHooverOutPutDTO roboticHooverOutPut = roboticHooverService.findHooverPositionAndDirtCleaned(roboticHooverInputDTO);
        ApiResponse<RoboticHooverOutPutDTO> response = new ApiResponse<>(HttpStatus.OK);
        response.setMessage("Retrieved response successfully");
        response.setData(roboticHooverOutPut);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
