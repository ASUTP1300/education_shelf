package ru.bee.arcollection.ivr.data.arcol.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ivrcontact", schema = "arcollection")
class IvrContact(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "IvrContactSequence")
    @SequenceGenerator(
        schema = "arcollection",
        name = "IvrContactSequence",
        sequenceName = "s_ivrcontact",
        allocationSize = 1
    )
    @Column(name = "contactid")
    var id: Long? = null,

    @Column(name = "taskId")
    var taskId: Long? = null,

    @Column(name = "idipgttask")
    var idIpGtTask: Long? = null,

    @Column(name = "ipgtcontactid")
    var ipGtContactId: Long? = null,

    @Column(name = "discdate")
    var discDate: LocalDateTime? = null,

    @Column(name = "finsupport")
    var finSupport: String? = null,

    @Column(name = "timeoffset")
    var timeOffset: Int? = null,

    @Column(name = "contactnumber")
    var contactNumber: String? = null,

    @Column(name = "contacttype")
    var contactType: Int? = null,

    @Column(name = "amountdue")
    var amountDue: BigDecimal? = null,

    @Column(name = "startdatetime")
    var startDateTime: LocalDateTime? = null,

    @Column(name = "dnis")
    var dnis: String? = null,

    @Column(name = "clid")
    var clid: String? = null,

    @Column(name = "status")
    var status: Int? = null,

    @Column(name = "laststatus")
    var lastStatus: Int? = null,

    @Column(name = "firstprocessed")
    var firstProcessed: LocalDateTime? = null,

    @Column(name = "processed")
    var processed: LocalDateTime? = null,

    @Column(name = "appid")
    var appId: String? = null,

    @Column(name = "sysname")
    var sysName: String? = null,

    @Column(name = "cycles")
    var cycles: Short? = null,

    @Column(name = "talktime")
    var talkTime: Int? = null,

    @Column(name = "currencyid")
    var currencyId: Int? = null,

    @OneToOne
    @JoinColumn(name = "coivractioncommunication")
    var ivrActionComm: IvrActionCommunication? = null
)