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
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.sql.DataSource


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["ru.data.arcol.repository", "ru.data.arcol.entity"],
    entityManagerFactoryRef = "arColEntityManagerFactory",
    transactionManagerRef = "arColTransactionManager"
)
class ArCollectionPersistenceConfig {


    @Bean(name =["arColDataSource"])
    @ConfigurationProperties( prefix = "spring.datasource")
    fun arColDataSource(): DataSource {
        return arColDataSourceProperties()
            .initializeDataSourceBuilder()
            .build()
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    fun arColDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    fun entityManagerFactoryBuilder(): EntityManagerFactoryBuilder {
        return EntityManagerFactoryBuilder(HibernateJpaVendorAdapter(), HashMap<String, Any?>(), null)
    }

    @Bean
    fun arColEntityManagerFactory(
        @Qualifier("arColDataSource") dataSource: DataSource,
        builder: EntityManagerFactoryBuilder
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource)
            .packages("ru.bee.arcollection.ivr.data.arcol.entity")
            .build()
            .apply {
                jpaVendorAdapter = HibernateJpaVendorAdapter()
                setJpaProperties(Properties().apply {
                    setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                }
                )
            }
    }

    @Bean("arColTransactionManager")
    fun arColTransactionManager(
        @Qualifier("arColEntityManagerFactory") arColEntityManagerFactory: LocalContainerEntityManagerFactoryBean
    ): PlatformTransactionManager {
        return JpaTransactionManager(
            arColEntityManagerFactory.getObject()
                ?: throw RuntimeException("Отсутвует arColEntityManagerFactory в контексте")
        )
    }

}