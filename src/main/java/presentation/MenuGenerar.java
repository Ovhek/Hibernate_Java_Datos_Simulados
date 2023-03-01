/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cole
 */
public abstract class MenuGenerar {

    private static final Logger logger = LogManager.getLogger(MenuPrincipal.class);

    public static void init() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Menú de Generación de Clases");
            System.out.println("1. Listar Clases");
            System.out.println("2. Generar Clase");
            System.out.println("3. Volver");
            System.out.println("4. Salir");

            int option = -1;
            if (sc.hasNextInt()) {
                option = sc.nextInt();
            }

            switch (option) {
                case 1:
                    
                    break;
                case 2:
                    generarClases();
                    break;
                case 3:
                    MenuPrincipal.init();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    throw new Exception("Opción invalida.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            init();
        }
    }

    private static void generarClases() {
        System.out.println("¿Qué clase quieres generar?");
        //listar
        System.out.println("Indica la cantidad de clases a generar.");
        
        System.out.println("Esta clase tienen entidades asociadas: ");
        
        System.out.println("Indica la cantidad de [] a generar. (tiene que ser mayor a 0)");
    }
}
