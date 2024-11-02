package ru.bee.arcollection.ivr.data.arcol.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * @author RManasipov
 * @since 03.08.2024
 */
@Entity
@Table(name = "ivrstatus", schema = "arcollection")
data class IvrStatus(
    @Id
    @Column(name = "coivrstatus")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "ivrstatusid")
    val ipGtId: String
)