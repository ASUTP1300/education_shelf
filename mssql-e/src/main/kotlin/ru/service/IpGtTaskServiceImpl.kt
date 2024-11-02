package ru.service

import org.jetbrains.kotlin.utils.threadLocal
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import ru.data.ipgt.entity.IpGtContact
import ru.data.ipgt.entity.IpGtTask
import ru.data.ipgt.repository.IpGtTaskRepository
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * @author RManasipov
 * @since 04.08.2024
 */
@Service
class IpGtTaskServiceImpl(
    private val ipGtTaskRepository: IpGtTaskRepository,
) {
    companion object {
        private val logger = LoggerFactory.getLogger(IpGtTaskServiceImpl::class.java)
    }

    @EventListener(value = [ApplicationReadyEvent::class])
    fun saveTask(): IpGtTask {
        val task = IpGtTask()

        val contact = IpGtContact()

        with(contact) {
            this.discDate = LocalDateTime.now()
            this.finSupport = "Собачье сердце"
        }

        with(task) {
            this.startDate = LocalDate.now().atStartOfDay()
            this.scenario = 1
            this.taskStatus = 1
            this.taskCreated = LocalDate.now().atStartOfDay()
            this.maxTimeOffset = 2
            this.ipGtContacts = setOf(IpGtContact())
        }
        val saved = ipGtTaskRepository.save(task)

        logger.info("Task :${saved} была сохранена в IpGt")
        return saved
    }

}