package ru.bee.arcollection.ivr.data.arcol.entity


import javax.persistence.*

@Entity
@Table(schema = "arfixcore", name = "paramvalscontract")
class ParamvalsContract(
    @Id
    @Column(name = "coentity")
    val id: Int,

    @ManyToOne
    @JoinColumn(name = "sale_point")
    val salesPoint: SalePoint
)