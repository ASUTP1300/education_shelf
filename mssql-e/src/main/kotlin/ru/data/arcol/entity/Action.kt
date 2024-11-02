package ru.bee.arcollection.ivr.data.arcol.entity

import javax.persistence.*


@Entity
@Table(schema = "arcollection", name = "action")
class Action(

    @Id
    @Column(name = "coaction")
    var id: Long? = null,

    @Column(name = "cocommunicationtemplatetype")
    var commTemplateTypeId: Long? = null,

    @Column(name = "actionstatus")
    var status: String? = null,

    @Column(name = "isauto")
    var isAuto: String? = null,

    @Column(name = "codebt")
    var debtId: Long? = null,

    @Column(name = "resultdescription")
    var resultdescription: String? = null,

    @OneToOne
    @JoinColumn(name = "coactiontype")
    var actionType: ActionType? = null,

    @ManyToOne
    @JoinColumn(name = "cocontract")
    var contract: Contract? = null,

    @ManyToOne
    @JoinColumn(name = "coactionresult")
    var result: ActionResult? = null
)