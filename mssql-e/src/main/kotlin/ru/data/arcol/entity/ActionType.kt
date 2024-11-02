package ru.bee.arcollection.ivr.data.arcol.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "arcollection", name = "actiontype")
class ActionType (
    @Id
    @Column(name = "coactiontype")
    val id: Long? = null,

    @Column(name = "name")
    val name: String? = null
)