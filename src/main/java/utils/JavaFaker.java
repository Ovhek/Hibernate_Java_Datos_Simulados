/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import aplicacion.model.Aeronau;
import aplicacion.model.Combat;
import aplicacion.model.Dron;
import aplicacion.model.Mecanic;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Transport;
import com.github.javafaker.Faker;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

/**
 * Clase encargada de generar datos falsos para las entidades
 */
public abstract class JavaFaker {

    private static Faker faker;

    private static void initFaker() {
        faker = new Faker();
    }

    private static Date utilDateToSqlDate(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }
    
    public static Object generarGenerico(Object objeto){
        if (objeto instanceof Combat) return generarCombat();
        if (objeto instanceof Transport) return generarTransport();
        if (objeto instanceof Dron) return generarDron();
        if (objeto instanceof Pilot) return generarPilot();
        if (objeto instanceof Mecanic) return generarMecanic();
        if (objeto instanceof Missio) return generarMissio();
        return null;
    }
    
    /**
     * Genera un objeto de tipo Combat
     * @return Objeto de tipo Combat
     */
    public static Combat generarCombat() {
        initFaker();
        String modelo = faker.ancient().god() + faker.number().digits(4);
        float mana = (float) faker.number().randomDouble(2, 100, 1000);
        Date ultimaRecarga = utilDateToSqlDate(faker.date().past(5, TimeUnit.DAYS));
        boolean magiaProhibida = faker.bool().bool();
        return new Combat(modelo, mana, ultimaRecarga, magiaProhibida);
    }

    /**
     * Genera un objeto de tipo Transport
     * @return Objeto de tipo Transport
     */
    public static Transport generarTransport() {
        initFaker();
        String modelo = faker.ancient().titan() + faker.number().digits(4);
        float mana = (float) faker.number().randomDouble(2, 1000, 10000);
        Date ultimaRecarga = utilDateToSqlDate(faker.date().past(5, TimeUnit.DAYS));
        boolean magiaProhibida = faker.bool().bool();
        return new Transport(modelo, mana, ultimaRecarga, magiaProhibida);
    }
    
    /**
     * Genera un objeto de tipo Dron
     * @return Objeto de tipo Dron
     */
    public static Dron generarDron() {
        initFaker();
        String modelo = faker.ancient().hero()+ faker.number().digits(4);
        float mana = (float) faker.number().randomDouble(2, 100, 500);
        Date ultimaRecarga = utilDateToSqlDate(faker.date().past(5, TimeUnit.DAYS));
        boolean magiaProhibida = faker.bool().bool();
        return new Dron(modelo, mana, ultimaRecarga, magiaProhibida);
    }
    
    /**
     * Genera un objeto de tipo Pilot
     * @return Objeto de tipo Pilot
     */
    public static Pilot generarPilot() {
        initFaker();
        String tipoMagia = faker.superhero().power();
        float poderMagico = (float) faker.number().randomDouble(2, 500, 2000);
        Date fechaRenacimiento = utilDateToSqlDate(faker.date().past(10, TimeUnit.DAYS));
        boolean mercenario = faker.bool().bool();
        return new Pilot(tipoMagia, poderMagico, fechaRenacimiento, mercenario);
    }
    
    /**
     * Genera un objeto de tipo Mecanic
     * @return Objeto de tipo Mecanic
     */
    public static Mecanic generarMecanic() {
        initFaker();
        String tipoMagia = faker.superhero().power();
        float poderMagico = (float) faker.number().randomDouble(2, 5000, 10000);
        Date fechaRenacimiento = utilDateToSqlDate(faker.date().past(10, TimeUnit.DAYS));
        boolean mercenario = faker.bool().bool();
        return new Mecanic(tipoMagia, poderMagico, fechaRenacimiento, mercenario);
    }
    
    /**
     * Genera un objeto de tipo Missio
     * @return Objeto de tipo Missio
     */
    public static Missio generarMissio() {
        initFaker();
        String infoAventura = faker.elderScrolls().quote();
        float poderMinimo = (float) faker.number().randomDouble(2, 500, 10000);
        Date fechaColapso = utilDateToSqlDate(faker.date().future(100, TimeUnit.DAYS));
        boolean realizado = faker.bool().bool();
        return new Missio(infoAventura, poderMinimo, fechaColapso, realizado);
    }
}
