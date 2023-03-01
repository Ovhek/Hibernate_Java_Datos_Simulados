/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

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
        EntityType<?> ent = null;
        for (EntityType<?> entidad : entidades) {
            if (entidad.getName().equals(entrada)) {
                ent = entidad;
            }
        }
        listarEntidad(ent, idInicial, idFinal);

    }

    public static void listarEntidades() {

        try {
            ss.beginTransaction();
            // Guardar todas las entidades en una lista
            Set<EntityType<?>> entidades = ss.getMetamodel().getEntities();
            for (EntityType<?> entidad : entidades) {
                System.out.println(entidad.getName());
            }

            ss.getTransaction().commit();

        } catch (HibernateException e) {
            ss.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /*public static void listarEntidadv2(EntityType<?> e, int idInicial, int idFinal) {
        CriteriaBuilder cb = ss.getCriteriaBuilder();
        CriteriaQuery<Entity> cq = cb.createQuery(Entity.class);
        Root<Entity> root = cq.from(Entity.class);
        cq.select(e).where(cb.between(root.get("@id"), idInicial, idFinal));
        List<Entity> results = ss.createQuery(cq).getResultList();
    }*/

    public static void listarEntidad(EntityType<?> e, int idInicial, int idFinal) {

        try {
            ss.beginTransaction();

            Query query = ss.createQuery("FROM " + e + " WHERE idArchivoArcaico BETWEEN " + idInicial + " AND " + idFinal);
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
