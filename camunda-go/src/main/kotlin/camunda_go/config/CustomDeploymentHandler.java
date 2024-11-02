package camunda_go.config;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.repository.DefaultDeploymentHandler;
import org.camunda.bpm.engine.repository.CandidateDeployment;
import org.camunda.bpm.engine.repository.DeploymentHandler;
import org.camunda.bpm.engine.repository.Resource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;
@Primary
@Component
public class CustomDeploymentHandler extends DefaultDeploymentHandler implements DeploymentHandler {
    public CustomDeploymentHandler(ProcessEngine processEngine) {
        super(processEngine);
    }

    @Override
    protected boolean resourcesDiffer(Resource resource, Resource existing) {
        return true;
    }

    @PostConstruct
    void test() {
        System.out.println("Я создан");
    }
}
