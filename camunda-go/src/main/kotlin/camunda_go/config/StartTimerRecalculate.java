//package camunda_go.config;
//
//import org.camunda.bpm.engine.ManagementService;
//import org.camunda.bpm.engine.impl.persistence.entity.TimerEntity;
//import org.camunda.bpm.spring.boot.starter.event.ProcessApplicationEvent;
//import org.camunda.bpm.spring.boot.starter.event.ProcessApplicationStartedEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public record StartTimerRecalculate(ManagementService managementService)
//        implements ApplicationListener<ProcessApplicationStartedEvent> {
//    @Override
//    public void onApplicationEvent(ProcessApplicationStartedEvent event) {
//
//
//
//        managementService.createJobQuery()
//                .timers()
//                .list()
//                .stream()
//                .map(job -> (TimerEntity) job)
//                .filter(timerEntity -> "timer-start-event".equals(timerEntity.getJobHandlerType()))
//                .forEach(timerEntity -> managementService.recalculateJobDuedate(timerEntity.getId(), true));
//
//    }
//}
