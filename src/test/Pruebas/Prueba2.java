/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Pruebas;

import Modelo.DataDAO.Data;
import Modelo.Default.PreguntasFrecuentes;

/**
 *
 * @author diosl
 */
public class Prueba2 {

    public static void main(String[] args) {
        Data data = new Data();
        PreguntasFrecuentes pre = new PreguntasFrecuentes(data);
        for (int i = 0; i < pre.listPreguntasFrecuentes().size(); i++) {
            System.out.println(pre.listPreguntasFrecuentes().get(i).getPregunta());
            System.out.println(pre.listPreguntasFrecuentes().get(i).getRespuesta());
            System.out.println("");
        }
    }
}
