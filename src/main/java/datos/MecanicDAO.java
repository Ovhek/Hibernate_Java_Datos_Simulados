/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;

/**
 * DAO para la clase de mecanic. Extiende del GenericDAOImpl
 */
public class MecanicDAO extends GenericDAOImpl<MecanicDAO, Integer>{
    
    public MecanicDAO(Class<MecanicDAO> clase) {
        super(MecanicDAO.class);
    }
    
}
