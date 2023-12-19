package camunda.service.camunda

import edu.spring_wf.client.PersonClient
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class PrinterDelegate(val client: PersonClient): JavaDelegate {
    final var counter = 0;

    override fun execute(p0: DelegateExecution?) {
        client.getById(1)
        counter = counter.plus(1)
        println("Принтер был вызван " + counter)
    }
}