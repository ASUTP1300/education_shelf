package camunda_go.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.postgresql.Driver;
import org.springframework.boot.CommandLineRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class DataBaseInitializer implements CommandLineRunner {
    private final static String ENV_DATA_SOURCE_URL = "spring.datasource.url";
    private final static String ENV_USER_NAME = "spring.datasource.user";
    private final static String ENV_PASSWORD = "spring.datasource.password";

    private final static String CAMUNDA_FILE_HOLDER = "arccamunda.act_ge_bytearray";

    private final String CAMUNDA_TRANCATE_FILE_HOLDER = "TRUNCATE";

    private static final String URLFIXED;
    private static final String USERNAME;
    private static final String PASSWORD;

    private Connection connection;

    private static final Properties settings = new Properties();

    static {
        Map<String, String>  envs = System.getenv();

        URLFIXED = envs.get(ENV_DATA_SOURCE_URL);
        USERNAME = envs.get(ENV_USER_NAME);
        PASSWORD = envs.get(ENV_PASSWORD);
    }


    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return connection;
    }



    @Override
    public void run(String... args) throws Exception {
        try {
            Connection connection = getConnection();

            if (connection != null) {
                System.out.println("Соединение установлено!");
            }
            connection.createStatement().executeUpdate("truncate camunda12.act_ge_bytearray CASCADE");
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Закрытие соединения
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}