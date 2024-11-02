import org.springframework.data.jpa.repository.JpaRepository
import ru.bee.arcollection.ivr.data.arcol.entity.IvrTask

interface IvrTaskRepository: JpaRepository<IvrTask, Long>