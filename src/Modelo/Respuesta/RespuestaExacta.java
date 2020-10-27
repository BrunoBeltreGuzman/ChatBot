/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Respuesta;

import Modelo.Connection.ConnectionAccess;
import Modelo.DataDAO.Data;
import Modelo.Default.Default;
import Vista.Ventanas.Ventana;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diosl
 */
public class RespuestaExacta extends ConnectionAccess implements IRespuesta {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int resultQuery = 0;

    private Ventana ventana;
    private Data data;

    public RespuestaExacta(Ventana ventana, Data data) {
        this.ventana = ventana;
        this.data = data;
    }

    @Override
    public void sendRespuesta(String pregunta, Ventana ventana) {
        if (!pregunta.equalsIgnoreCase("")) {
            String respuesta = getRespuesta(pregunta);
            if (!respuesta.equalsIgnoreCase("")) {
                ventana.getTextArea().append(data.getTab() + respuesta + "\n");
            } else {
                Default.sendRespuestaDefault(ventana, data);
            }
        } else {
            Default.sendRespuestaDefault(ventana, data);
        }
    }

    @Override
    public String getRespuesta(String pregunta) {
        resultQuery = 0;
        connection = getConnection();
        try {

            String sql = "SELECT respuesta FROM PreguntasYRespuestas "
                    + "where pregunta = '" + pregunta + "'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("respuesta");
            } else {
                //registrar Respuestas
                return "";
            }
        } catch (SQLException sqlException) {
            super.printException(sqlException);
            return sqlException.getMessage();
        } finally {
            super.closeConnection(connection);
            super.closePreparedStatement(preparedStatement);
            super.closeResultSet(resultSet);
        }
    }

    @Override
    public void sendWelcome(Ventana ventana) {
        ventana.getTextArea().setText("");
        ventana.getTextArea().append("");
        ventana.getTextArea().append("© Copyright MicroSystems DO 2020" + "\n");
        ventana.getTextArea().append("ChatBot ChatBot MicroSystems DO v1" + "\n");
        ventana.getTextArea().append("Función Respuesta Exacta" + "\n" + "\n");
    }
}
