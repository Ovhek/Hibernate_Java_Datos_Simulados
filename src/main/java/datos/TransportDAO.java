/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;

/**
 * DAO para la clase de transport. Extiende del GenericDAOImpl
 */
public class TransportDAO extends GenericDAOImpl<TransportDAO, Integer>{
    
    public TransportDAO(Class<TransportDAO> clase) {
        super(TransportDAO.class);
    }
    
}
