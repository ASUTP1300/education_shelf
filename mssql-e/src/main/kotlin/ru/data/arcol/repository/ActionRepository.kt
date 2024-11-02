package ru.bee.arcollection.ivr.data.arcol.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.bee.arcollection.ivr.data.arcol.entity.Action

interface ActionRepository: JpaRepository<Action, Long>