/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;

/**
 * DAO para la clase de missio. Extiende del GenericDAOImpl
 */
public class MissioDAO extends GenericDAOImpl<MissioDAO, Integer>{
    
    public MissioDAO(Class<MissioDAO> clase) {
        super(MissioDAO.class);
    }
    
}
