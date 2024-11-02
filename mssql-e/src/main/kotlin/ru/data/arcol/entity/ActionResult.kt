package ru.bee.arcollection.ivr.data.arcol.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "arcollection", name = "actionresult")
class ActionResult(
    @Id
    @Column(name = "coactionresult")
    val id: Long,

    @Column(name = "name")
    val name: String
)