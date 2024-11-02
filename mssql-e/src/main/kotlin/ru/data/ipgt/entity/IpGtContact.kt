package ru.data.ipgt.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "cff_contacts", schema = "dp")
class IpGtContact(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "discdate")
    var discDate: LocalDateTime? = null,

    @Column(name = "finsupport")
    var finSupport: String? = null,

    @Column(name = "timeoffset")
    var timeOffset: Int? = null,

    @Column(name = "contract_number")
    var contractNumber: String? = null,

    @Column(name = "contract_type")
    var contractType: Int? = null,

    @Column(name = "amountdue")
    var amountDue: BigDecimal? = null,

    @Column(name = "currencyid")
    var currencyId: Int? = null,

    @Column(name = "startdatetime")
    var startDateTime: LocalDateTime? = null,

    @Column(name = "dnis")
    var dnis: String? = null,

    @ManyToOne
    @JoinColumn(name = "task_id")
    var task: IpGtTask ? = null
) {
    override fun toString(): String {
        return "IpGtContact(id=$id, discDate=$discDate, finSupport=$finSupport, timeOffset=$timeOffset, contactNumber=$contractNumber, contactType=$contractType, amountDue=$amountDue, currencyId=$currencyId, startDateTime=$startDateTime, dnis=$dnis)"
    }
}