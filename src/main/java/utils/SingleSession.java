/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ivan
 */
public class SingleSession {
    private static Session sessio;
    private static SingleSession singleSession;
    private static SessionFactory factory;
    private static final Logger logger = LogManager.getLogger(SingleSession.class);
    
    private SingleSession() {
        HibernateUtils.setSetSessionFactory("root", "1234", "test");
        factory = HibernateUtils.getSessionFactory();
        sessio =  factory.openSession();
    }

    public static SingleSession getInstance() {
        if(singleSession == null) {
            singleSession = new SingleSession();
        }
        
        return singleSession;
    }

    public static void closeSession(){
        if(factory != null) factory.close();
        if(sessio != null) sessio.close();
    }
    
    public Session getSessio() {
        return sessio;
    }
    
    public void setSessio(Session sessio) {
        this.sessio = sessio;
    }

    public static SingleSession getSingleSession() {
        return singleSession;
    }

    public static void setSingleSession(SingleSession singleSession) {
        SingleSession.singleSession = singleSession;
    } 
    
    //Sobreescribimos el método clone, para que no se pueda clonar un objeto de esta clase
    @Override
    public SingleSession clone() throws CloneNotSupportedException {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            logger.error("No se puede clonar un objeto de la clase SingleSession");
        }
        return null;
    }
    
}
