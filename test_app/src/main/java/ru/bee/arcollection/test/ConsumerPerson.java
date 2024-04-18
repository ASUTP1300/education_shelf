package ru.bee.arcollection.test;

import edu.spring_wf.client.PersonClient;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerPerson {
    private final PersonClient client;

    public ConsumerPerson(PersonClient client) {
        this.client = client;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void send() {
        client.getById(1);
    }
}
