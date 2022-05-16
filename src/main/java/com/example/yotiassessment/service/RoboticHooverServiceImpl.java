package com.example.yotiassessment.service;

import com.example.yotiassessment.dto.RoboticHooverInputDTO;
import com.example.yotiassessment.dto.RoboticHooverOutPutDTO;
import com.example.yotiassessment.model.RoboticHooverInput;
import com.example.yotiassessment.model.RoboticHooverOutPut;
import com.example.yotiassessment.repository.RoboticHooverInputRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RoboticHooverServiceImpl implements RoboticHooverService{

    private final RoboticHooverInputRepository roboticHooverInputRepository;

    private final ModelMapper modelMapper;

    public RoboticHooverServiceImpl(RoboticHooverInputRepository roboticHooverInputRepository, ModelMapper modelMapper) {
        this.roboticHooverInputRepository = roboticHooverInputRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public RoboticHooverOutPutDTO findHooverPositionAndDirtCleaned(RoboticHooverInputDTO roboticHooverInputDTO) {

        int gridXLength = roboticHooverInputDTO.getRoomSize().get(0);
        int gridYLength = roboticHooverInputDTO.getRoomSize().get(1);
        int currentPositionX = roboticHooverInputDTO.getCoords().get(0);
        int currentPositionY = roboticHooverInputDTO.getCoords().get(1);
        List<String> directions = List.of(roboticHooverInputDTO.getInstructions().split(""));
        List<List<Integer>> dirtPatches = roboticHooverInputDTO.getPatches();
        Set<List<Integer>> cleanDirtPatches = new HashSet<>();

        RoboticHooverInput roboticHooverInput = roboticHooverInputRepository.save(modelMapper.map(roboticHooverInputDTO, RoboticHooverInput.class));

        for (String direction : directions) {
            if (Objects.equals(direction, "N") && currentPositionY < gridYLength) {
                currentPositionY++;
                checkForDirt(currentPositionX, currentPositionY, dirtPatches, cleanDirtPatches);
            } else if (Objects.equals(direction, "S") && currentPositionY > 0) {
                currentPositionY--;
                checkForDirt(currentPositionX, currentPositionY, dirtPatches, cleanDirtPatches);
            } else if (Objects.equals(direction, "E") && currentPositionX < gridXLength) {
                currentPositionX++;
                checkForDirt(currentPositionX, currentPositionY, dirtPatches, cleanDirtPatches);
            } else if (Objects.equals(direction, "W") && currentPositionX > 0) {
                currentPositionX--;
                checkForDirt(currentPositionX, currentPositionY, dirtPatches, cleanDirtPatches);
            }
        }

        RoboticHooverOutPutDTO roboticHooverOutPut = new RoboticHooverOutPutDTO();
        List<Integer> coords = List.of(currentPositionX, currentPositionY);
        roboticHooverOutPut.setCoords(coords);
        roboticHooverOutPut.setPatches(cleanDirtPatches.size());

        roboticHooverInput.setRoboticHooverOutPut(modelMapper.map(roboticHooverOutPut, RoboticHooverOutPut.class));
        roboticHooverInputRepository.save(roboticHooverInput);
        return roboticHooverOutPut;
    }

    private static void checkForDirt(int currentX, int currentY,  List<List<Integer>> dirtPatches, Set<List<Integer>> cleanDirtPatches){
        for (List<Integer> dirtPatch : dirtPatches) {
            if (currentX == dirtPatch.get(0) && currentY == dirtPatch.get(1)) {
                cleanDirtPatches.add(List.of(dirtPatch.get(0), dirtPatch.get(1)));
            }
        }
    }
}
