package camunda_go.service.camunda

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class PrinterComponent(
    private val runtimeService: RuntimeService
): JavaDelegate {
    val MESSAGE_START = "MessageHTTP"

    override fun execute(p0: DelegateExecution?) {

        println("Печатаю сообщение  ${p0?.getVariable("Message")} ")
    }
}