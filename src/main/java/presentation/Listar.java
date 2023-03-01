/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import aplicacion.model.Missio;
import jakarta.persistence.Entity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.PluralAttribute;
import java.util.ArrayList;
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
            for (EntityType<?> entidad : entidades) {
                System.out.println(entidad.getName());
            }
            
            System.out.println();
            
            // Buscar los registros de la tabla de Missio
            List<Missio> llista = ss.createQuery("from Missio", Missio.class).list();
            for(Missio ms: llista) {
                System.out.println("MISSIO:: " + ms.toString());
            }
            logger.info("LLISTA::: " + llista);
            
            // Filtrar los registros por rango de Id's
            List<Missio> listaDestino = llista.stream().filter(x -> x.getAtributIdentificador() >= idInicial && x.getAtributIdentificador() <= idFinal).toList();
            logger.info("LISTA FILTRADA POR ID:::" + listaDestino);

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
