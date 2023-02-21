/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Función de utilidad para crear una sesión de hibernate según los datos
 * proporcionados por el usuario.
 */
public abstract class HibernateUtils {

    private static SessionFactory sessionFactory;

    /**
     * Crea la configuración de Hibernate con el usuario, contraseña y base de datos.
     * @param username usuario
     * @param password contraseña
     * @param database base de datos.
     */
    public static void setSetSessionFactory(String username, String password, String database) {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.username", username);
            configuration.setProperty("hibernate.connection.password", password);
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + database);
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            
        }

    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
}
