package camunda_go.service.camunda;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component

public record CamundaService(RuntimeService runtimeService) {

//    @Scheduled(cron = "${test.cron:0 1 * * * ?}")
//    public void startSimple(){
//        runtimeService.startProcessInstanceByKey("SimpleS");
//
//    }

    @PostConstruct
    void test(){
        runtimeService.startProcessInstanceByKey("SimpleS");
    }
}
