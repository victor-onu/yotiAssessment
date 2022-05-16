package com.example.yotiassessment.service;

import com.example.yotiassessment.dto.RoboticHooverInputDTO;
import com.example.yotiassessment.dto.RoboticHooverOutPutDTO;
import com.example.yotiassessment.model.RoboticHooverOutPut;
import org.springframework.stereotype.Service;

@Service
public interface RoboticHooverService {
    RoboticHooverOutPutDTO findHooverPositionAndDirtCleaned(RoboticHooverInputDTO roboticHooverInputDTO);
}
