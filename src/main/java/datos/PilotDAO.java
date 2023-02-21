/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;

/**
 * DAO para la clase de pìlot. Extiende del GenericDAOImpl
 */
public class PilotDAO extends GenericDAOImpl<PilotDAO, Integer>{
    
    public PilotDAO(Class<PilotDAO> clase) {
        super(PilotDAO.class);
    }
    
}
