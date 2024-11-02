//package camunda_go.config;
//
//import lombok.AllArgsConstructor;
//import org.camunda.bpm.engine.impl.calendar.CycleBusinessCalendar;
//import org.camunda.bpm.engine.impl.util.ClockUtil;
//import org.springframework.context.annotation.Primary;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.scheduling.support.SimpleTriggerContext;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.Optional;
//
//@Primary
//@Component
//@AllArgsConstructor
//public class TZCycleBusinessCalendar extends CycleBusinessCalendar {
//
//    public static final String NAME = "cycle";
//
//    private Config config;
//
//    @Override
//    public Date resolveDuedate(String duedateDescription) {
//        return resolveDuedate(duedateDescription);
//    }
//
//    @Override
//    public Date resolveDuedate(String duedateDescription, Date startDate) {
//        try {
//            // replace description from config  if needed
//            duedateDescription = Optional.ofNullable(config.getCycleProcess())
//                    .orElse(duedateDescription);
//
//            if (duedateDescription.startsWith("R")) {
//                return super.resolveDuedate(duedateDescription, startDate);
//            }
//            String cronExpression = duedateDescription;
//                CronTrigger ct = new CronTrigger(cronExpression);
//                SimpleTriggerContext triggerContext = new SimpleTriggerContext();
//                triggerContext.update(null, null, ClockUtil.getCurrentTime());
//                return ct.nextExecutionTime(triggerContext);
//
//        } catch (Exception e) {
//        }
//        throw new RuntimeException("А тут что-то пошло не так...");
//    }
//
//}