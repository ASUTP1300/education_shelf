package ru.bee.arcollection.ivr.data.arcol.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.bee.arcollection.ivr.data.arcol.entity.ActionResult

interface ActionResultRepository : JpaRepository<ActionResult, Long> {
    @Query(
        """
            SELECT R
              FROM ActionResult R
             WHERE R.name = :name
        """
    )
    fun findByName(name: String): ActionResult?
}
