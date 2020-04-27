package com.michelouadria.trotracesimulator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageHandlerTest {


    @Test
    void fetchMessages() {
        MessageHandler messageHandler = new MessageHandler();
        String response = messageHandler.fetchMessages();

        assertNotNull(response);
        assertEquals(response, String.class);
    }
}