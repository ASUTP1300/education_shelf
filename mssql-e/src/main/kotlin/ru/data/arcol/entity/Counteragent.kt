package ru.bee.arcollection.ivr.data.arcol.entity

import org.hibernate.annotations.Immutable
import javax.persistence.*

@Entity
@Table(schema = "arfixcore", name = "counteragent")
@Immutable
class Counteragent(
        @Id
        @Column(name = "cocounteragent")
        val id: Long,

        @Enumerated(value = EnumType.STRING)
        @Column(name = "islegalentity")
        val legalEntity: IsLegal
)