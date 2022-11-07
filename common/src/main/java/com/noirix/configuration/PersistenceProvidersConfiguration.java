package com.noirix.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class PersistenceProvidersConfiguration {

    public static final String COM_NOIRIX = "com.noirix";
    public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public static final String HIBERNATE_DEFAULT_SCHEMA = "hibernate.default_schema";
    public static final String CURRENT_SESSION_CONTEXT_CLASS = "current_session_context_class";
    public static final String ORG_SPRINGFRAMEWORK_ORM_HIBERNATE_5_SPRING_SESSION_CONTEXT = "org.springframework.orm.hibernate5.SpringSessionContext";
    public static final String TRUE = "true";
    public static final String CINEMA = "cinema";

    @Autowired
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(COM_NOIRIX);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(getAdditionalProperties());

        return em;
    }

    private Properties getAdditionalProperties() {
        Properties properties = new Properties();

        properties.put(HIBERNATE_SHOW_SQL, TRUE);
        properties.put(HIBERNATE_DEFAULT_SCHEMA, CINEMA);
        properties.put(CURRENT_SESSION_CONTEXT_CLASS, ORG_SPRINGFRAMEWORK_ORM_HIBERNATE_5_SPRING_SESSION_CONTEXT);
        return properties;
    }
}
