package ru.bee.arcollection.ivr.data.arcol.entity

import org.hibernate.annotations.Immutable
import javax.persistence.*

@Entity
@Table(schema = "arfixcore", name = "contract")
@Immutable
class Contract(
    @Id
    @Column(name = "cocontract")
    val id: Int,

    @Column(name = "nmcontract")
    val number: String?,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cocounteragent")
    val counteragent: Counteragent,

    @OneToOne(mappedBy = "contract")
    val collectionContract: CollectionContract
)