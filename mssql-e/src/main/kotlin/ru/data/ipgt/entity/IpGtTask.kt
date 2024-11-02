package ru.data.ipgt.entity

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.time.LocalDateTime
import javax.persistence.*

/**
 * @author RManasipov
 * @since 04.08.2024
 */
@Entity
@Table(name = "cff_tasks", schema = "dp")
class IpGtTask(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null,

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

    @OneToMany(mappedBy = "task")
    @Cascade(CascadeType.ALL)
    var ipGtContacts: Set<IpGtContact>? = null
) {
    override fun toString(): String {
        return "IpGtTask(id=$id, startDate=$startDate, scenario=$scenario, taskStatus=$taskStatus, taskCreated=$taskCreated, maxTimeOffset=$maxTimeOffset, ipGtContacts=$ipGtContacts)"
    }
}
