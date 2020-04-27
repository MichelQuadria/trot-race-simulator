package com.michelouadria.trotracesimulator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "trotrace")
public class TrotRace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String event;

    @Column
    private int horseId;

    @Column
    private String name;

    @Column
    private int time;

    public TrotRace(String event, int horseId, String name, int time) {
        this.event = event;
        this.horseId = horseId;
        this.name = name;
        this.time = time;
    }



}
