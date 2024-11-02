package ru.bee.arcollection.ivr.data.arcol.entity

import javax.persistence.*

@Entity
@Table(schema = "arfixmdm", name = "mdc_refsalepoint")
class SalePoint(
    @Id
    @Column(name = "corefsalepoint")
    val id: String,

    @ManyToOne
    @JoinColumn(name = "cocity", referencedColumnName = "cocity")
    val city: City?
)