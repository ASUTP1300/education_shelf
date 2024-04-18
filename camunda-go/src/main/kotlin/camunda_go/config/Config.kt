package camunda_go.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct


@Configuration
//@EnableFeignClients(
//    clients = [
//        PersonClient::class
//    ]
//)
open class Config {

    @Value(value = "\${camunda_go.process.cycle.cron}")
    val cycleProcess: String? = null

    @PostConstruct
    fun show() {
        println("Цикл запуска процесса в КРОН $cycleProcess ")

    }

}