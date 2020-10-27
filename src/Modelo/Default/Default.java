/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Default;

import Modelo.Connection.ConnectionAccess;
import Modelo.DataDAO.Data;
import Vista.Ventanas.Ventana;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diosl
 */
public class Default {

    private static String[] respuestaDefault = {
        "ok",
        "Todo Bien?",
        "Como le puedo ayudar",
        "Dime como le puedo ayudar",
        "Yaaaa"};

    public static void sendRespuestaDefault(Ventana ventana, Data data) {
        String respuesta = getRespuestaDefault();
        ventana.getTextArea().append(data.getTab() + respuesta + "\n");
    }

    private static String getRespuestaDefault() {
        try {
            int i = (int) Math.floor(Math.random() * 4 + 1);
            return respuestaDefault[i];
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return respuestaDefault[1];
        }
    }

}
