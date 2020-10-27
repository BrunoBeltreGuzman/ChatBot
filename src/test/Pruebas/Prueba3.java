/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Pruebas;

import Modelo.DataDAO.Data;
import Modelo.Respuesta.RespuestaCoincidencia;
import Vista.Ventanas.Ventana;

/**
 *
 * @author diosl
 */
public class Prueba3 {

    /*  Prueba para repuesta por conincidencia
     *  Con el metodo getPorcentaje se obtiene
     *  el porcentaje de conincidencia de cada
     *  pregunta de esta manera se puede seleccional
     *  la pregunta mas acertante.
     */
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        Data data = new Data();
        int poc = new RespuestaCoincidencia(ventana, data).getPorcentaje("HO", "hola");
        System.out.println(poc + "%");
    }
}
