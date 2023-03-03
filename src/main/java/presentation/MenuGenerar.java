/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import aplicacion.ClassFactory;
import aplicacion.CombatLogic;
import aplicacion.DronLogic;
import aplicacion.MecanicLogic;
import aplicacion.MissioLogic;
import aplicacion.PilotLogic;
import aplicacion.TransportLogic;
import aplicacion.model.Combat;
import aplicacion.model.Dron;
import aplicacion.model.Mecanic;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Pilotada;
import aplicacion.model.Transport;
import datos.CombatDAO;
import datos.DronDAO;
import datos.MecanicDAO;
import datos.MissioDAO;
import datos.PilotDAO;
import datos.TransportDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cole
 */
public abstract class MenuGenerar {

    private static CombatLogic combatLogic = new CombatLogic(new CombatDAO());
    private static DronLogic dronLogic = new DronLogic(new DronDAO());
    private static MecanicLogic mecanicLogic = new MecanicLogic(new MecanicDAO());
    private static MissioLogic missioLogic = new MissioLogic(new MissioDAO());
    private static PilotLogic pilotLogic = new PilotLogic(new PilotDAO());
    private static TransportLogic transportLogic = new TransportLogic(new TransportDAO());

    private static final Logger logger = LogManager.getLogger(MenuPrincipal.class);
    private static Scanner sc = new Scanner(System.in);

    public static void init() {
        try {
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
        try {
            do {

                System.out.println("¿Qué clase quieres generar?");
                System.out.println("1 - Combat");
                System.out.println("2 - Transport");
                System.out.println("3 - Mecanic");
                System.out.println("4 - Missio");
                System.out.println("5 - Dron");
                System.out.println("6 - Pilot");
                System.out.println("7 - Volver");
                System.out.println("8 - Salir");

                int option = -1;
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                    sc.nextLine();
                }

                int numAGenerar = -1;
                do {
                    System.out.println("Indica la cantidad de clases a generar.");
                    if (sc.hasNextInt()) {
                        numAGenerar = sc.nextInt();
                        sc.nextLine();
                    }
                } while (numAGenerar < 0);

                List<Object> objetosGenerados = new ArrayList<>();

                ClassFactory classFactory = new ClassFactory();

                switch (option) {
                    case 1:

                        System.out.println("Esta clase tienen entidades asociadas de tipo Missio: ");
                        System.out.println("¿Cuantas Entidades de tipo Missio quieres agregar a la nave? [min 1, max 2]");

                        int entidadesRelacionAGenerar = -1;
                        do {
                            if (sc.hasNextInt()) {
                                entidadesRelacionAGenerar = sc.nextInt();
                                sc.nextLine();
                            }
                        } while (entidadesRelacionAGenerar < 0 && entidadesRelacionAGenerar > 2);

                        for (int i = 0; i < numAGenerar; i++) {
                            Pilotada aeronau = (Pilotada) classFactory.aeronauFactory(Combat.class);
                            Pilot pilot = (Pilot) classFactory.soldatFactory(Pilot.class);
                            classFactory.addPilotToAeronauPilotada(pilot, aeronau);
                            List<Missio> missions = classFactory.missionsFactory(entidadesRelacionAGenerar);
                            classFactory.addMissionsToAeronau(missions, aeronau);

                            combatLogic.guardarCombat((Combat) aeronau);

                        }

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                    case 6:
                        break;
                    case 7:
                        MenuPrincipal.init();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        throw new Exception("Opción invalida.");
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            generarClases();
        }

    }

    private static Combat generarCombat() {
        return null;
    }

    private static Transport generarTransport() {
        return null;
    }

    private static Mecanic generarMecanic() {
        return null;
    }

    private static Missio generarMissio() {
        return null;
    }

    private static Dron generarDron() {
        return null;
    }

    private static Pilot generarPilot() {
        return null;
    }
}
