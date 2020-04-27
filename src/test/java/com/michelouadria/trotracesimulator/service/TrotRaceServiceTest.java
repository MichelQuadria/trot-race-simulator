package com.michelouadria.trotracesimulator.service;

import com.michelouadria.trotracesimulator.model.EventDTO;
import com.michelouadria.trotracesimulator.model.HorseDTO;
import com.michelouadria.trotracesimulator.model.TrotRace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrotRaceServiceTest {


    @Test
    void createTrotRace() {
        TrotRaceService trotRaceService = new TrotRaceService();
        HorseDTO horseDTO = new HorseDTO(1,"Dazzle");
        EventDTO eventDTO = new EventDTO("start",1354,horseDTO);
        TrotRace trotRace = trotRaceService.createTrotRace(eventDTO,horseDTO);

        assertEquals(trotRace.getEvent(),eventDTO.getEvent());
        assertEquals(trotRace.getTime(),eventDTO.getTime());
        assertEquals(trotRace.getName(),horseDTO.getHorse());
        assertEquals(trotRace.getHorseId(),horseDTO.getId());

    }
}