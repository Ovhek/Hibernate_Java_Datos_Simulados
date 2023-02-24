/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.PluralAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.metamodel.model.domain.internal.EntityTypeImpl;
import org.hibernate.metamodel.model.domain.internal.SingularAttributeImpl;

/**
 *
 * @author DAM
 */
public class Listar {

    static Session sf = HibernateUtils.getSessionFactory().getCurrentSession();

    public static void listarEntitades() {

        try {
            sf.beginTransaction();
            // Guardar todas las entidades en una lista
            Set<EntityType<?>> entidades = sf.getMetamodel().getEntities();
            List<String> listEntidades = new ArrayList<>();

            for (EntityType<?> entidad : entidades) {
                listEntidades.add(((EntityTypeImpl) entidad).getTypeName());
            }
            sf.getTransaction().commit();

        } catch (HibernateException e) {
            sf.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void listarAtributos() {
        Set<EntityType<?>> entidades = sf.getMetamodel().getEntities();
        //Set<?> listEntities;
        Set<PluralAttribute<?, ?, ?>> plural;
        Set<SingularAttributeImpl<?, ?>> single;
        for (EntityType entidad : entidades) {
            plural = entidad.getDeclaredPluralAttributes();
            single = entidad.getSingularAttributes();
            System.out.println("****************************************");
            System.out.println(entidad.getName());
            for (PluralAttribute<?, ?, ?> x : plural) {
                System.out.println(x.getName() + "__" + x.getBindableJavaType());
            }
            for (SingularAttributeImpl<?, ?> x : single) {
                System.out.println(x.getName() + "__" + x.getBindableJavaType());
            }
        }
    }
    
}
