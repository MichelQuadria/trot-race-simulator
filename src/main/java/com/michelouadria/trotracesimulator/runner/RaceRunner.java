package com.michelouadria.trotracesimulator.runner;

import com.michelouadria.trotracesimulator.controller.TrotRaceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class RaceRunner implements CommandLineRunner {


    @Autowired
    TrotRaceController trotRaceController;

    @Override
    public void run(String... args) throws Exception {
        while (true){
            String response = trotRaceController.requestMessage();
            System.out.println("RESPONSE to be stored " + response);
                trotRaceController.storeResult(response);
        }
    }


}
