/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import static aplicacion.ListarLogic.listarEntidadFiltrada;
import static aplicacion.ListarLogic.listarEntidades;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import utils.HibernateUtils;
import utils.SingleSession;


/**
 *
 * @author ivan
 */
public class MenuListar {
    
    /**
     * Menú que devuelve las entidades que desea listar el usuario, filtradas por un rango de id's
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException 
     */
    public static void menuListar() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIndica qué entidades quieres listar:");
        listarEntidades();
        String entrada = sc.nextLine();
        System.out.println("Indica el id inicial:");
        int idInicial = sc.nextInt();
        System.out.println("Indica el id final:");
        int idFinal = sc.nextInt();
        
        System.out.println("\nLas entidades encontradas son:");
        listarEntidadFiltrada(entrada, idInicial, idFinal);
    }
}
