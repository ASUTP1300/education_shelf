package camunda.service.camunda



import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component


@Component
class Test {
    companion object {
        val logger = LoggerFactory.getLogger(Test::class.java)
    }

    @EventListener(classes = [ApplicationReadyEvent::class])
    fun test() {
        logger.trace("Hello world !");
    }
}