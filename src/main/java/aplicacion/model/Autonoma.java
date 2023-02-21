/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.sql.Date;

/**
 *
 * @author Cole
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Autonoma extends Aeronau {

    public Autonoma(int identificadorArcano, String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(identificadorArcano, modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Autonoma(String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Autonoma() {
    }
    
    
}
