package ru.config


import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import java.util.*
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(
    basePackages = ["ru.data.ipgt.repository"],
    entityManagerFactoryRef = "ipGtEntityManagerFactory",
    transactionManagerRef = "ipGtTransactionManager"
)
class IpGtPersistenceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    fun ipGtDataSource(): DataSource {
        return ipGtDataSourceProperties()
            .initializeDataSourceBuilder()
            .build()
    }

    @Bean
    @ConfigurationProperties("spring.datasource.ipgt")
    fun ipGtDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }


    @Bean
    fun ipGtEntityManagerFactory(
        @Qualifier("ipGtDataSource") dataSource: DataSource,
        builder: EntityManagerFactoryBuilder
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource)
            .packages("ru.data.ipgt.entity")
            .build()
            .apply {
                jpaVendorAdapter = HibernateJpaVendorAdapter()
                setJpaProperties(Properties().apply {
                    setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect")
                }
                )
            }
    }

    @Bean
    fun ipGtTransactionManager(
        @Qualifier("ipGtEntityManagerFactory") ipGtEntityManagerFactory: LocalContainerEntityManagerFactoryBean
    ): PlatformTransactionManager {
        return JpaTransactionManager(
            ipGtEntityManagerFactory.getObject()
                ?: throw RuntimeException("Отсутвует ipGtEntityManagerFactory в контексте")
        )
    }

}