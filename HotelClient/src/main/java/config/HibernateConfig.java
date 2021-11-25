package config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.schema.Action;

import javax.persistence.EntityManager;
import java.util.Properties;

public class HibernateConfig {

    // Hibernate SessionFactory
    public static SessionFactory sessionFactory;

    public static EntityManager entityManager;

    static {
        createSessionFactory();
    }

    private static void createSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Hibernate Configuration-objekt erzeugen
                final Configuration cfg = new Configuration();

                // Properties definieren
                Properties settings = new Properties();

                // JDBC-Verbindungskonfiguration
                settings.put(Environment.DRIVER, EnviromentConfig.getProperty("hibernate.connection.driver_class"));
                settings.put(Environment.URL, EnviromentConfig.getProperty("hibernate.connection.url"));
                settings.put(Environment.USER, EnviromentConfig.getProperty("hibernate.connection.username"));
                settings.put(Environment.PASS, EnviromentConfig.getProperty("hibernate.connection.password"));

                // Hibernate Konfiguration
                // Hibernate Dialect konfigurieren
                settings.put(Environment.DIALECT, EnviromentConfig.getProperty("hibernate.dialect"));

                // die generierten SQL-Anweisungen auf der Konsole ausdrucken
                settings.put(Environment.SHOW_SQL, EnviromentConfig.getProperty("hibernate.show_sql"));

                // die generierten SQL-Anweisungen formatieren
                settings.put(Environment.FORMAT_SQL, EnviromentConfig.getProperty("hibernate.format_sql"));

                // das Datenbankschema manipulieren - das Datenbankschema löschen, erzeugen und wieder löschen
                settings.put(Environment.HBM2DDL_AUTO, Action.interpretHbm2ddlSetting(EnviromentConfig.getProperty("hibernate.hbm2ddl.auto")));

                // die Settings in der Konfiguration registrieren
                cfg.addProperties(settings);

                // die Entitäten registrieren

                // ServiceRegistry-Objekt erzeugen
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
                sessionFactory = cfg.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // EntityManager-Objekt erzeugen
    public static EntityManager createEntityManager() {
        if (entityManager == null) {
            entityManager = sessionFactory.createEntityManager();
        }
        return entityManager;
    }
}
