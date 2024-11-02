package camunda_go.service.camunda

//import edu.spring_wf.client.PersonClient
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Component
class PrinterDelegate(
//    val client: PersonClient,
): JavaDelegate {
    companion object {
        val log = Logger.getLogger(PrinterDelegate::class.java.toString())
    }

    val text:String = "Кофе с молоком"

    final var counter = 0;

    override fun execute(p0: DelegateExecution?) {
//        client.getById(1)
        counter = counter.plus(1)

        println("Принтер был вызван " + counter)
        log.info("Принтер был вызван " + counter + " REQUEST_STATUS $text")
    }
}