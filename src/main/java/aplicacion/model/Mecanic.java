/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.sql.Date;

/**
 *
 * @author Cole
 */
@Entity
public class Mecanic extends Soldat implements TesteableEntity{

    public Mecanic(int numColegiado, String tipoMagia, float poderMagico, Date fechaRenacimiento, boolean mercenario) {
        super(numColegiado, tipoMagia, poderMagico, fechaRenacimiento, mercenario);
    }

    public Mecanic(String tipoMagia, float poderMagico, Date fechaRenacimiento, boolean mercenario) {
        super(tipoMagia, poderMagico, fechaRenacimiento, mercenario);
    }

    public Mecanic() {
    }

    public Pilotada getPilotada() {
        return pilotada;
    }

    public void setPilotada(Pilotada pilotada) {
        this.pilotada = pilotada;
    }

    @ManyToOne(optional = false)
    private Pilotada pilotada;
    
    @Override
    public Integer getAtributIdentificador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAtributString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Float getAtributFloat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Date getAtributDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean getAtributBoolean() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributString(String s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributFloat(Float f) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributDate(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributBoolean(Boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
