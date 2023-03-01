/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Aeronau;
import aplicacion.model.Combat;
import aplicacion.model.Dron;
import aplicacion.model.Mecanic;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Pilotada;
import aplicacion.model.Soldat;
import aplicacion.model.Transport;
import java.util.ArrayList;
import java.util.List;
import utils.JavaFaker;

/**
 *
 * @author Cole
 */
public class ClassFactory implements TesteableFactory {

    @Override
    public Aeronau addMecanicsToPilotada(List<Soldat> lo, Pilotada p) throws Exception {
        if (lo.size() < 0 || lo.size() > 2) {
            throw new Exception("El valor debe estar entre 0 y 2");
        }
        ArrayList<Mecanic> mecanic = new ArrayList<>();
        lo.forEach(e -> {
            ((Mecanic) e).setPilotada(p);
            mecanic.add((Mecanic) e);
        });
        p.setMecanics(mecanic);
        return p;
    }

    @Override
    public Aeronau addMissionsToAeronau(List<Missio> lm, Aeronau a) throws Exception {
        if (a.getMissions() != null) {
            ArrayList<Missio> missions = a.getMissions();
            if (lm.size() > 2) {
                throw new Exception("Como maximo se pueden añadir 2 misiones");
            }
            missions.addAll(lm);
            while(missions.size()>2){
                missions.remove(0);
            }
        } else {
            a.setMissions(lm);
        }

        return a;
    }

    @Override
    public Missio addAeronausToMissio(List<Aeronau> la, Missio m) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Aeronau addPilotToAeronauPilotada(Pilot p, Pilotada a) throws Exception {
        a.setPilot(p);
        return a;
    }

    @Override
    public Aeronau aeronauFactory(Class<?> tipus) {
        Aeronau aeronau = null;
        if (tipus.equals(Dron.class)) {
            aeronau = JavaFaker.generarDron();
        } else if (tipus.equals(Combat.class)) {
            aeronau = JavaFaker.generarCombat();
        } else if (tipus.equals(Transport.class)) {
            aeronau = JavaFaker.generarTransport();
        }
        return aeronau;
    }

    @Override
    public List<Soldat> mecanicsFactory(int elements) {
        List<Soldat> lista = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            lista.add(JavaFaker.generarMecanic());
        }
        return lista;
    }

    @Override
    public Missio missioFactory() {
        return JavaFaker.generarMissio();
    }

    @Override
    public List<Missio> missionsFactory(int elements) {
        List<Missio> lista = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            lista.add(JavaFaker.generarMissio());
        }
        return lista;
    }

    @Override
    public List<Soldat> pilotsFactory(int elements) {
        List<Soldat> lista = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            lista.add(JavaFaker.generarPilot());
        }
        return lista;
    }

    @Override
    public Soldat soldatFactory(Class<?> tipus) {
        Soldat soldat = null;
        if (tipus.equals(Mecanic.class)) {
            soldat = JavaFaker.generarMecanic();
        } else if (tipus.equals(Pilot.class)) {
            soldat = JavaFaker.generarPilot();
        }
        return soldat;
    }

}
