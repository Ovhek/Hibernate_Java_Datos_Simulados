/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Cole
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="pilotada")
public abstract class Pilotada extends Aeronau implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToOne(optional = true)
    @JoinColumn(name = "pilot_id")
    private Pilot pilot;

    @OneToMany(mappedBy = "pilotada", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Mecanic> mecanics = new ArrayList<>();

    public Pilotada(int identificadorArcano, String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(identificadorArcano, modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Pilotada(String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Pilotada() {
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public ArrayList<Mecanic> getMecanics() {
        return mecanics;
    }

    public void setMecanics(ArrayList<Mecanic> mecanics) {
        this.mecanics = mecanics;
    }

}
