package ru.bee.arcollection.ivr.data.arcol.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "ivractioncommunication", schema = "arcollection")
class IvrActionCommunication(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "IvrActionCommunicationSequence")
    @SequenceGenerator(
        schema = "arcollection",
        name = "IvrActionCommunicationSequence",
        sequenceName = "s_ivractioncommunication",
        allocationSize = 1
    )
    @Column(name = "coactioncommunication")
    var id: Long? = null,

    @Column(name = "createdbyid")
    var createdById: Long? = null,

    @Column(name = "changedbyid")
    var changedById: Long? = null,

    @Column(name = "amount")
    var amount: BigDecimal? = null,

    @Column(name = "attemptscount")
    var attemptsCount: String? = null,

    @Column(name = "cocurrency")
    var currencyId: String? = null,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "number")
    var number: String? = null,

    @Column(name = "talktime")
    var talkTime: String? = null,

    @ManyToOne
    @JoinColumn(name = "coivrstatus")
    var ivrStatus: IvrStatus? = null,

    @Column(name = "coaction")
    var actionId: Long? = null
): BaseEntity()