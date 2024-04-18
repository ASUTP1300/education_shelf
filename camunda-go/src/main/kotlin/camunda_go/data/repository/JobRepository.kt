package camunda_go.data.repository

import camunda_go.data.entity.Job
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JobRepository: JpaRepository<Job, Long> {
}