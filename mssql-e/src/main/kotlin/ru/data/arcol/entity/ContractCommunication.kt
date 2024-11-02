package ru.bee.arcollection.ivr.data.arcol.entity

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "contractcommunication", schema = "arcollection")
data class ContractCommunication(

    @Id
    @Column(name = "cocontractcommunication")
    val id: Long,

    @Column(name = "number")
    val number: String? = null,

    @Column(name = "isusedforivr")
    val isUsedForIvr: String? = null,

    @Column(name = "cocollectioncontract")
    val collectionContractId: Long
) : Serializable