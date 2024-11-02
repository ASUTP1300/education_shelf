package camunda_go.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;


@Configuration
public class Config {

    @Value(value = "${camunda_go.process.cycle.cron}")
    String cycleProcess;


    public String getCycleProcess() {
        return cycleProcess;
    }

    @PostConstruct
    void show() {
        System.out.println("Цикл запуска процесса в КРОН " + cycleProcess);
    }

}