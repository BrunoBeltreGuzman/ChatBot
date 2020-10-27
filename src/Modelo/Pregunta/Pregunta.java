/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Pregunta;

import Modelo.Connection.ConnectionAccess;
import Modelo.DataDAO.Data;
import Vista.Ventanas.Ventana;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author diosl
 */
public class Pregunta extends ConnectionAccess {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int resultQuery = 0;
    private Data data;

    public Pregunta(Data data) {
        this.data = data;
    }

    public void sendPregunta(Ventana ventana) {
        String message = ventana.getTextMessage().getText().trim();
        if (!message.equalsIgnoreCase("")) {
            if (message == "do preguntasf" || message == "do ") {

            } else {
                ventana.getTextArea().append(message + "\n");
                ventana.getTextMessage().setText("");
                data.setPregunta(message);
            }
        } else {
            data.setPregunta("");
        }
    }
}
