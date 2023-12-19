package camunda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CamundaApp

fun main(args: Array<String>) {
    runApplication<CamundaApp>(*args)
}