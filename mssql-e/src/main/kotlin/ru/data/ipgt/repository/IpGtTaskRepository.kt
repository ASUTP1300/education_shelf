package ru.data.ipgt.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.data.ipgt.entity.IpGtTask

/**
 * @author RManasipov
 * @since 04.08.2024
 */
interface IpGtTaskRepository: JpaRepository<IpGtTask, Int> {
}