import org.postgresql.Driver
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class CamundaCleaner: CommandLineRunner {
    private val ENV_DATA_SOURCE_URL = "spring.datasource.url"
    private val ENV_USER_NAME = "spring.datasource.user"
    private val ENV_PASSWORD = "spring.datasource.password"

    private val CAMUNDA_FILE_HOLDER = "arccamunda.act_ge_bytearray"

    private val CAMUNDA_TRANCATE_FILE_HOLDER = "TRUNCATE " + CAMUNDA_FILE_HOLDER + "CASCADE"

    private var URLFIXED: String? = null
    private var USERNAME: String? = null
    private var PASSWORD: String? = null

    private var connection: Connection? = null

    init
    {
        val envs: Map<String, String> = System.getenv();

        this.URLFIXED = envs.get(ENV_DATA_SOURCE_URL);
        this.USERNAME = envs.get(ENV_USER_NAME);
        this.PASSWORD = envs.get(ENV_PASSWORD);
    }

    companion object {
        val log = LoggerFactory.getLogger(CamundaCleaner::class.java)
    }


    private fun getConnection(): Connection? {
        try {
            DriverManager.registerDriver(Driver())
            connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD)
        } catch (e1: SQLException) {
           throw RuntimeException(e1.message)
        }
        return connection
    }


    override fun run(vararg args: String?) {
        try {
            val connection = getConnection()
            connection!!.createStatement().executeUpdate(CAMUNDA_TRANCATE_FILE_HOLDER)
        } catch (e: RuntimeException) {
            log.warn("В Camunda данные о загруженных bpmn не были очищены, ошибка ${e.printStackTrace()}")
        } finally {
            if (connection != null) {
                try {
                    connection!!.close()
                } catch (e: SQLException) {
                   log.warn("Ошибка закрытия соединения ${e.printStackTrace()}")
                }
            }
        }
    }
}