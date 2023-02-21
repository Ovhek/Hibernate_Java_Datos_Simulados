/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Cole
 */
@Entity
public abstract class Pilotada extends Aeronau {

    @OneToOne(optional = true)
    private Pilot pilot;
    
    @OneToMany(mappedBy="pilotada", cascade=CascadeType.ALL, orphanRemoval=true)
    private ArrayList<Mecanic> mecanics = new ArrayList<>();
    
    public Pilotada(int identificadorArcano, String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(identificadorArcano, modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Pilotada(String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Pilotada() {
    }
    
}
