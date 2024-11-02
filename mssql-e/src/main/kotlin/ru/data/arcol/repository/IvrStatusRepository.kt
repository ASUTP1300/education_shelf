import org.springframework.data.jpa.repository.JpaRepository
import ru.bee.arcollection.ivr.data.arcol.entity.IvrStatus

interface IvrStatusRepository: JpaRepository<IvrStatus, Long> {
    fun findByIpGtId(ipGtId: String): IvrStatus
}