/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import static aplicacion.ListarLogic.listarEntidadFiltrada;
import static aplicacion.ListarLogic.listarEntidades;
import jakarta.persistence.metamodel.EntityType;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Set;
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

    private static final Logger logger = LogManager.getLogger(HibernateUtils.class);
    private static Session ss = SingleSession.getInstance().getSessio();

    public static void menuListar() throws ClassNotFoundException, NoSuchMethodException, NoSuchMethodException, InstantiationException, InstantiationException, IllegalAccessException, InvocationTargetException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica qué entidades quieres listar:");
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
