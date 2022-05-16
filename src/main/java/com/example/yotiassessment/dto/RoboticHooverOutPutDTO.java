package com.example.yotiassessment.dto;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
public class RoboticHooverOutPutDTO {
    private List<Integer> coords;
    private Integer patches;
}
