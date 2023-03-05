/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import jakarta.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.SingleSession;

/**
 *
 * DAO generico para todas las entidades de hibernate
 *
 * @param <Entidad> Objeto (Entidad)
 * @param <ID> extends Serializable (El tipo de ID (objeto) solo puede ser de tipo
 * serializable --> que se puede convertir a una secuencia de bytes y luego a un
 * objeto otra vez)
 *
 * Uso: public class CombatDAO extends GenericDAOImpl<CombatDAO, int> 
 */
public abstract class GenericDAOImpl<Entidad, ID extends Serializable> implements GenericDAOInterface<Entidad, ID>{

    //Clase sobre la cual se va a realizar los DAO.
    private Class<Entidad> clase;

    public GenericDAOImpl(Class<Entidad> clase) {
        this.clase = clase;
    }
    
    /**
     * Obtiene una sesión.
     * @return sesión de Hibernate
     */
    private Session getSession() {
        return SingleSession.getInstance().getSessio();
    }

    public void guardar(Entidad entidad) {
        Session session = getSession();
        Transaction tx = null;
        try {
            
            tx = session.beginTransaction();
            if (session.contains(entidad)) session.merge(entidad);
            else session.persist(entidad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void actualizar(Entidad entidad) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(entidad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void eliminar(Entidad entidad) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.remove(entidad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Entidad obtener(ID id) {
        Session session = getSession();
        try {
            Entidad entidad = session.get(clase, id);
            return entidad;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public ArrayList<Entidad> obtenerTodos() {
        Session session = getSession();
        try {
            ArrayList<Entidad> entidades = new ArrayList(session.createQuery("from " + clase.getName(), clase.getClass()).list());
            return entidades;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

}
