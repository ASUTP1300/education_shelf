package ru.bee.arcollection.ivr.data.arcol.entity

import javax.persistence.*

@Entity
@Table(schema = "arcollection", name = "collectioncontract")
class CollectionContract(

    @Id
    @Column(name = "cocollectioncontract")
    val id: Long? = null,

    @OneToMany
    @JoinColumn(name = "cocollectioncontract", referencedColumnName = "cocollectioncontract", insertable = false, updatable = false)
    val contractCommunications: Set<ContractCommunication>?,

    @OneToOne
    @JoinColumn(name = "cocontract", referencedColumnName = "coentity", insertable = false, updatable = false)
    val paramvalsContract: ParamvalsContract,

    @OneToOne
    @JoinColumn(name = "cocontract")
    val contract: Contract
)