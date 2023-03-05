/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Aeronau;
import aplicacion.model.Autonoma;
import aplicacion.model.Combat;
import aplicacion.model.Dron;
import aplicacion.model.Mecanic;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Pilotada;
import aplicacion.model.Soldat;
import aplicacion.model.Transport;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.PluralAttribute;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.metamodel.model.domain.internal.SingularAttributeImpl;
import utils.HibernateUtils;
import utils.JavaFaker;
import utils.SingleSession;

/**
 *
 * @author ivan
 */
public class ListarLogic {

    private static final Session ss = SingleSession.getInstance().getSessio();
    private static final Logger logger = LogManager.getLogger(HibernateUtils.class);

    /**
     * Método que lista todas las Entidades
     */
    public static void listarEntidades() {
        // Guardar todas las entidades en una lista
        Set<EntityType<?>> entidades = ss.getMetamodel().getEntities();
        for (EntityType<?> entidad : entidades) {
            System.out.println(entidad.getName());
        }
    }

    /**
     * Listar todos los registros que sean del tipo de Entidad filtrada por un
     * rango de id's. Todo elegido por el usuario.
     *
     * @param entidad
     * @param idInicial
     * @param idFinal
     */
    public static void listarEntidadFiltrada(String entidad, int idInicial, int idFinal) {
        try {            
            /*Pilot p = JavaFaker.generarPilot();
            ss.beginTransaction();
            ss.persist(p);

            Mecanic m = JavaFaker.generarMecanic();
            ss.persist(m);
            ss.getTransaction().commit();*/

            switch (entidad) {

                case "Pilot":

                    // Buscar los registros de la tabla de Pilot
                    List<Pilot> llistaPilot = ss.createQuery("from " + entidad, Pilot.class).list();

                    List<Pilot> llistaFiltradaPilot = llistaPilot.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaPilot);

                    break;

                case "Aeronau":
                    
                    // Buscar los registros de la tabla de Aeronau y sus Entidades "hijas"
                    List<Aeronau> llistaAeronau = ss.createQuery("from " + entidad, Aeronau.class).list();

                    List<Aeronau> llistaFiltradaAeronau = llistaAeronau.stream().filter(x -> x.getIdentificadorArcano()>= idInicial && x.getIdentificadorArcano() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaAeronau);

                    break;

                case "Dron":

                    // Buscar los registros de la tabla de Dron
                    List<Dron> llistaDron = ss.createQuery("from " + entidad, Dron.class).list();

                    List<Dron> llistaFiltradaDron = llistaDron.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaDron);

                    break;

                case "Soldat":
                    
                    // Buscar los registros de la tabla de Soldat y sus Entidades "hijas"
                    List<Soldat> llistaSoldat = ss.createQuery("from " + entidad, Soldat.class).list();

                    List<Soldat> llistaFiltradaSoldat = llistaSoldat.stream().filter(x -> x.getNumColegiado()>= idInicial && x.getNumColegiado()<= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaSoldat);

                    break;

                case "Mecanic":
                    
                    // Buscar los registros de la tabla de Mecanic
                    List<Mecanic> llistaMecanic = ss.createQuery("from " + entidad, Mecanic.class).list();

                    List<Mecanic> llistaFiltradaMecanic = llistaMecanic.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaMecanic);

                    break;

                case "Transport":

                    // Buscar los registros de la tabla de Transport
                    List<Transport> llistaTransport = ss.createQuery("from " + entidad, Transport.class).list();

                    List<Transport> llistaFiltradaTransport = llistaTransport.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaTransport);

                    break;

                case "Combat":

                    // Buscar los registros de la tabla de Combat
                    List<Combat> llistaCombat = ss.createQuery("from " + entidad, Combat.class).list();

                    // Filtrar los registros por rango de Id's
                    List<Combat> llistaFiltradaCombat = llistaCombat.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaCombat);

                    break;

                case "Missio":
                    // Buscar los registros de la tabla de Missio
                    List<Missio> llistaMissio = ss.createQuery("from " + entidad, Missio.class).list();

                    // Filtrar los registros por rango de Id's
                    List<Missio> listaFiltradaMissio = llistaMissio.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + listaFiltradaMissio);
                    break;

                case "Autonoma":
                    
                    // Buscar los registros de la tabla de Autonoma y sus Entidades "hijas"
                    List<Autonoma> llistaAutonoma = ss.createQuery("from " + entidad, Autonoma.class).list();

                    // Filtrar los registros por rango de Id's
                    List<Autonoma> listaFiltradaAutonoma = llistaAutonoma.stream().filter(x -> x.getIdentificadorArcano()>= idInicial && x.getIdentificadorArcano() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + listaFiltradaAutonoma);

                    break;

                case "Pilotada":
                    
                    // Buscar los registros de la tabla de Pilotada y sus Entidades "hijas"
                    List<Pilotada> llistaPilotada = ss.createQuery("from " + entidad, Pilotada.class).list();

                    // Filtrar los registros por rango de Id's
                    List<Pilotada> listaFiltradaPilotada = llistaPilotada.stream().filter(x -> x.getIdentificadorArcano()>= idInicial && x.getIdentificadorArcano() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + listaFiltradaPilotada);

                    break;
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Listar los Atributos de cada Entidad
     */
    public static void listarAtributos() {
        Set<EntityType<?>> entidades = ss.getMetamodel().getEntities();
        Set<PluralAttribute<?, ?, ?>> plural;
        Set<SingularAttributeImpl<?, ?>> single;

        for (EntityType entidad : entidades) {
            plural = entidad.getDeclaredPluralAttributes();
            single = entidad.getSingularAttributes();
            System.out.println("\n****************************************\n");
            System.out.println(entidad.getName());

            for (PluralAttribute<?, ?, ?> x : plural) {
                System.out.println(x.getName() + ": " + x.getJavaType().getSimpleName());
            }
            for (SingularAttributeImpl<?, ?> x : single) {
                System.out.println(x.getName() + ": " + x.getJavaType().getSimpleName());
            }
        }
    }
}
