package com.michelouadria.trotracesimulator.controller;

import com.michelouadria.trotracesimulator.model.MessageHandler;
import com.michelouadria.trotracesimulator.service.TrotRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class TrotRaceController {


    @Autowired
    private TrotRaceService trotRaceService;

    @Autowired
    private MessageHandler messageHandler;


    public String requestMessage(){
        String json = messageHandler.fetchMessages();
        if(json.equals(null)) {
            requestMessage();
        }
        return  json;
    }

    public void storeResult(String json) {

        trotRaceService.addEvent(json);
    }

}
