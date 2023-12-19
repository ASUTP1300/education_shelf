package edu.spring_upload_file.test;

import edu.spring_wf.client.PersonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Test {
    @Autowired
    public PersonClient client;

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        client.getById(1);
    }

}