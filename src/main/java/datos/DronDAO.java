/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;

/**
 * DAO para la clase de dron. Extiende del GenericDAOImpl
 */
public class DronDAO extends GenericDAOImpl<DronDAO, Integer>{
    
    public DronDAO(Class<DronDAO> clase) {
        super(DronDAO.class);
    }
    
}
