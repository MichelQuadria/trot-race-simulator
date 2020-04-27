package com.michelouadria.trotracesimulator.service;

import com.google.gson.Gson;
import com.michelouadria.trotracesimulator.model.EventDTO;
import com.michelouadria.trotracesimulator.model.HorseDTO;
import com.michelouadria.trotracesimulator.model.TrotRace;
import com.michelouadria.trotracesimulator.repository.TrotRaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrotRaceService {


    @Autowired
    TrotRaceRepository trotRaceRepository;

    public void addEvent(String json) {
        Gson gson = new Gson();
        EventDTO event = gson.fromJson(json, EventDTO.class);
        HorseDTO horse = event.getHorse();
        TrotRace trotRace = createTrotRace(event,horse);

        storeEvent(trotRace);
    }

    public TrotRace createTrotRace(EventDTO eventDTO,HorseDTO horseDTO) {
        return new TrotRace(eventDTO.getEvent(),horseDTO.getId(),horseDTO.getHorse(),eventDTO.getTime());

    }

    private void storeEvent(TrotRace raceEvent) {
        trotRaceRepository.save(raceEvent);
    }


}
