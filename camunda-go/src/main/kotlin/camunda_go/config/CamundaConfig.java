package camunda_go.config;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.repository.DefaultDeploymentHandler;
import org.camunda.bpm.engine.repository.DeploymentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class CamundaConfig {

    @Autowired
    ApplicationContext applicationContext;

    @PostConstruct
    void test() {
        System.out.println("AppConfiguration");
    }

}
