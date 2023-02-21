/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;

/**
 * DAO para la clase de combate. Extiende del GenericDAOImpl
 */
public class CombatDAO extends GenericDAOImpl<CombatDAO, Integer>{
    
    public CombatDAO(Class<CombatDAO> clase) {
        super(CombatDAO.class);
    }
    
}
