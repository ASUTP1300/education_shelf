package camunda_go.service.camunda


import camunda_go.data.repository.JobRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component


@Component
class Test(
    private val repository: JobRepository
) {
    companion object {
        val logger = LoggerFactory.getLogger(Test::class.java)
    }

    @EventListener(classes = [ApplicationReadyEvent::class])
    fun test() {
        logger.trace("Hello world !");
        logger.info("Джоба: " + repository.findById(1).get())
    }
}