/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class SingleSession {
    private static Session sessio;
    private static SingleSession singleSession;

    private SingleSession(Session sessio) {
        this.sessio = sessio;
    }

    public static SingleSession getInstance() {
        if(singleSession == null) {
            singleSession = new SingleSession(sessio);
        } else {
            System.out.println("No se puede crear el objeto "+ sessio + " porque ya existe un objeto de la clase SingleSession");
        }
        
        return singleSession;
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
            System.out.println("No se puede clonar un objeto de la clase SingleSession");
        }
        return null;
    }
    
}