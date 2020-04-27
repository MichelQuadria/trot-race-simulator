package com.michelouadria.trotracesimulator.model;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@NoArgsConstructor
public class MessageHandler {


    private static final String API_URL = "http://35.207.169.147/results";

    @Autowired
    RestTemplate restTemplate;

    public String fetchMessages() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class);

        if (checkForNoContent(result.getStatusCode()) || result.getBody().equals(null)) {
            System.out.println("No Content found. Initiating new request");
            fetchMessages();
        }
        return result.getBody();
    }

    private boolean checkForNoContent(HttpStatus status){
        return status.equals(HttpStatus.NO_CONTENT);
    }
}
