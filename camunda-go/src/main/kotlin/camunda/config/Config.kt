package camunda.config

import edu.spring_wf.client.PersonClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(
    clients = [
        PersonClient::class
    ]
)
class Config {

    @Value(value = "\${camunda.process.cycle.cron}")
    val cycleProcess: String? = null
}