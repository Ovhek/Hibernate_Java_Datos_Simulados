/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import aplicacion.model.Combat;
import aplicacion.model.Dron;
import aplicacion.model.Mecanic;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Transport;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.PluralAttribute;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.metamodel.model.domain.internal.SingularAttributeImpl;
import org.hibernate.query.Query;
import utils.HibernateUtils;
import utils.JavaFaker;
import utils.SingleSession;

/**
 *
 * @author ivan
 */
public class Listar {

    private static final Logger logger = LogManager.getLogger(HibernateUtils.class);
    private static Session ss = SingleSession.getInstance().getSessio();

    public static void menuListar() {
        Scanner sc = new Scanner(System.in);
        Set<EntityType<?>> entidades = ss.getMetamodel().getEntities();

        System.out.println("Indica qué entidades quieres listar:");
        listarEntidades();
        String entrada = sc.nextLine();
        System.out.println("Indica el id inicial:");
        int idInicial = sc.nextInt();
        System.out.println("Indica el id final:");
        int idFinal = sc.nextInt();
        /*EntityType<?> ent = null;
        for (EntityType<?> entidad : entidades) {
            if (entidad.getName().equals(entrada)) {
                ent = entidad;
            }
        }*/
        listarEntidad(entrada, idInicial, idFinal);

    }

    /**
     * Listar todas las Entidades
     */
    public static void listarEntidades() {
        try {
            // Guardar todas las entidades en una lista
            Set<EntityType<?>> entidades = ss.getMetamodel().getEntities();
            for (EntityType<?> entidad : entidades) {
                System.out.println(entidad.getName());
            }
            System.out.println();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Listar todas las entidades que estén entre el rango de id's elegido por
     * el usuario anteriormente
     *
     * @param s
     * @param idInicial
     * @param idFinal
     */
    public static void listarEntidad(String s, int idInicial, int idFinal) {
        try {
            Set<EntityType<?>> entidades = ss.getMetamodel().getEntities();
            /*Missio m = JavaFaker.generarMissio();
            ss.beginTransaction();
            ss.persist(m);
            ss.getTransaction().commit();*/

            switch (s) {

                case "Pilot":
                    
                    // Buscar los registros de la tabla de Pilot
                    List<Pilot> llistaPilot = ss.createQuery("from " + s, Pilot.class).list();
                    for (Pilot pi : llistaPilot) {
                        System.out.println(pi.toString());
                    }
                    logger.info(llistaPilot);

                    List<Pilot> llistaFiltradaPilot = llistaPilot.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaPilot);

                    break;

                case "Aeronau":

                    break;

                case "Dron":
                    
                    // Buscar los registros de la tabla de Dron
                    List<Dron> llistaDron = ss.createQuery("from " + s, Dron.class).list();
                    for (Dron dr : llistaDron) {
                        System.out.println(dr.toString());
                    }
                    logger.info(llistaDron);

                    List<Dron> llistaFiltradaDron = llistaDron.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaDron);

                    break;

                case "Soldat":

                    break;

                case "Mecanic":
                    
                    // Buscar los registros de la tabla de Mecanic
                    List<Mecanic> llistaMecanic = ss.createQuery("from " + s, Mecanic.class).list();
                    for (Mecanic me : llistaMecanic) {
                        System.out.println(me.toString());
                    }
                    logger.info(llistaMecanic);

                    List<Mecanic> llistaFiltradaMecanic = llistaMecanic.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaMecanic);

                    break;

                case "Transport":
                    
                    // Buscar los registros de la tabla de Transport
                    List<Transport> llistaTransport = ss.createQuery("from " + s, Transport.class).list();
                    for (Transport tr : llistaTransport) {
                        System.out.println(tr.toString());
                    }
                    logger.info(llistaTransport);

                    List<Transport> llistaFiltradaTransport = llistaTransport.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaTransport);

                    break;

                case "Combat":
                    
                    // Buscar los registros de la tabla de Combat
                    List<Combat> llistaCombat = ss.createQuery("from " + s, Combat.class).list();
                    for (Combat ms : llistaCombat) {
                        System.out.println(ms.toString());
                    }
                    logger.info(llistaCombat);

                    // Filtrar los registros por rango de Id's
                    List<Combat> llistaFiltradaCombat = llistaCombat.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + llistaFiltradaCombat);

                    break;

                case "Missio":
                    // Buscar los registros de la tabla de Missio
                    List<Missio> llistaMissio = ss.createQuery("from " + s, Missio.class).list();
                    for (Missio ms : llistaMissio) {
                        System.out.println(ms.toString());
                    }
                    logger.info(llistaMissio);

                    /*String queryString = "from " + s;
                    Query query = ss.createQuery(queryString);
                    List results = query.list();
                    logger.info("RESULTS::: " + results);*/
                    // Filtrar los registros por rango de Id's
                    List<Missio> listaFiltradaMissio = llistaMissio.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
                    logger.info("LISTA FILTRADA POR ID:::" + listaFiltradaMissio);

                    break;

                case "Autonoma":

                    break;

                case "Pilotada":

                    break;

            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    // Listar los Atributos de cada Entidad
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
