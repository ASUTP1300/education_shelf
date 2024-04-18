package edu.spring_wf.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(
        clients = PersonClient.class
)
public class ClientAutoConfig {
}
