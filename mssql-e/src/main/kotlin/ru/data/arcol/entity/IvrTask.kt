package ru.bee.arcollection.ivr.data.arcol.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ivrtask")
class IvrTask (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "IvrTaskSequence")
    @SequenceGenerator(
        schema = "arcollection",
        name = "IvrTaskSequence",
        sequenceName = "s_ivrtask",
        allocationSize = 1
    )
    @Column(name = "taskid")
    val id: Long? = null,

    @Column(name = "idipgttask")
    var idIpGtTask: Long? = null,

    @Column(name = "startdate")
    var startDate: LocalDateTime? = null,

    @Column(name = "scenario")
    var scenario: Int? = null,

    @Column(name = "taskstatus")
    var taskStatus: Int? = null,

    @Column(name = "taskcreated")
    var taskCreated: LocalDateTime? = null,

    @Column(name = "maxtimeoffset")
    var maxTimeOffset: Int? = null,

    @Column(name = "collectionStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    var collectionStatus: CollectionStatus? = null,

    @OneToMany
    @JoinColumn(name = "taskid", referencedColumnName = "taskid")
    var ivrContacts: Set<IvrContact>? = null
)