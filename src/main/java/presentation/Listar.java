/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import aplicacion.model.Missio;
import aplicacion.model.Transport;
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
import org.hibernate.metamodel.model.domain.internal.EntityTypeImpl;
import org.hibernate.metamodel.model.domain.internal.SingularAttributeImpl;
import org.hibernate.query.Query;
import utils.HibernateUtils;
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
        for (EntityType<?> entidad : entidades) {
            System.out.println(entidad.getName());
        }
        String entrada = sc.nextLine();
        EntityType<?> ent = null;
        for (EntityType<?> entidad : entidades) {
            if(entidad.getName().equals(entrada)){
                ent = entidad;
            }
        }
        listarEntidad(ent);

    }

    public static void listarEntidades() {

        try {
            ss.beginTransaction();
            // Guardar todas las entidades en una lista
            Set<EntityType<?>> entidades = ss.getMetamodel().getEntities();
            List<String> listEntidadesAbstractas = new ArrayList<>();
            List<String> listEntidades = new ArrayList<>();

            for (EntityType<?> entidad : entidades) {
                logger.info("ENTIDAD::: " + entidad.getName());
                if (((EntityTypeImpl) entidad).getJavaType().getSuperclass().toString().contains("Object")) {
                    logger.info("ENTIDAD ABSTRACTA: " + ((EntityTypeImpl) entidad).getName());
                    listEntidadesAbstractas.add(((EntityTypeImpl) entidad).getName());
                }
            }
            for (EntityType<?> entidad : entidades) {
                boolean bol = false;
                logger.info("ENTIDAD::: " + entidad.getName());
                if (((EntityTypeImpl) entidad).getJavaType().getSuperclass().toString().contains("model")) {
                    logger.info("POSIBLE ENTIDAD NO ABSTRACTA: " + ((EntityTypeImpl) entidad).getName());
                    for (String e : listEntidadesAbstractas) {
                       logger.info("COMPARANDO CON E: " + e);
                        if (!((EntityTypeImpl) entidad).getJavaType().getSuperclass().toString().contains(e) && !listEntidadesAbstractas.contains(entidad.getName())) {
                            bol = true;
                        } else {
                            bol = false;
                            //listEntidadesAbstractas.add(entidad.getName());
                            break;
                        }
                    }
                }
                if (bol) {
                    logger.info("ENTIDAD " + entidad.getName() + " AÑADIDA");
                    listEntidades.add(((EntityTypeImpl) entidad).getName());
                }
                logger.info("SUPERCLASS:: " + ((EntityTypeImpl) entidad).getJavaType().getSuperclass());
            }
            System.out.println("ENTIDADES: " + listEntidades);
            ss.getTransaction().commit();

        } catch (HibernateException e) {
            ss.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void listarEntidad(EntityType<?> e) {

        try {
            ss.beginTransaction();
            
            // Guardar todas las entidades en una lista
            Set<EntityType<?>> entidades = ss.getMetamodel().getEntities();
            List<String> listEntidades = new ArrayList<>();

            Query query = ss.createQuery("from " + e);
            logger.info("QUERY::: " + query.getQueryString());
            
            /*List<Missio> select = new ArrayList<>();

            //select.addAll(query.list());
            select = query.list();*/

            List<EntityType> select = query.list();
            
            ss.getTransaction().commit();

        } catch (HibernateException ex) {
            ss.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public static void listarAtributos() {
        Set<EntityType<?>> entidades = ss.getMetamodel().getEntities();
        //Set<?> listEntities;
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
