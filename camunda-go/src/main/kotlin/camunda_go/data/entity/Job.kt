package camunda_go.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "arccamunda12" , name = "job")
class Job(
    @Id
    @Column(name = "cojob")
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null
) {
    override fun toString(): String {
        return "Job(id=$id, name=$name)"
    }
}