package com.example.yotiassessment.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@TypeDefs({@TypeDef(name = "json", typeClass = JsonStringType.class)})
@Table(name = "robotic_hoover_outputs")
public class RoboticHooverOutPut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<Integer> coords;

    private Integer patches;

    @OneToOne(mappedBy = "roboticHooverOutPut")
    private RoboticHooverInput roboticHooverInput;

}
