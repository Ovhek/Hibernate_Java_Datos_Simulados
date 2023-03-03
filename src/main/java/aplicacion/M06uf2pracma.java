/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package aplicacion;

import aplicacion.model.Combat;
import presentation.Listar;
import presentation.MenuCredenciales;
import presentation.MenuPrincipal;

import presentation.MenuCredenciales;

/**
 *
 * @author Cole
 */
public class M06uf2pracma {

    public static void main(String[] args) {
        MenuCredenciales.init();
        Listar.menuListar();       
        MenuPrincipal.init();
        Listar.listarEntidades();

    }

}
