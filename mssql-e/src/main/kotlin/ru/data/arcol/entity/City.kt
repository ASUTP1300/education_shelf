package ru.bee.arcollection.ivr.data.arcol.entity

import org.hibernate.annotations.Immutable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "arcollection", name = "city")
@Immutable
class City(

    @Id
    @Column(name = "cocity")
    val id: Long,

    @Column(name = "moscowtimeoffset")
    val moscowTimeOffset: Int
)