package com.example.yotiassessment.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@TypeDefs({@TypeDef(name = "json", typeClass = JsonStringType.class)})
@Table(name = "robotic_hoover_inputs")
public class RoboticHooverInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList<Integer> roomSize;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList<Integer> coords;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Object patches;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roboticHooverOutPut_id", referencedColumnName = "id")
    private RoboticHooverOutPut roboticHooverOutPut;

    private String instructions;
}
