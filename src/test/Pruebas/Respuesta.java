/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Pruebas;

import Modelo.Connection.ConnectionAccess;
import Modelo.DataDAO.Data;
import Vista.Ventanas.Ventana;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author diosl
 */
public class Respuesta extends ConnectionAccess {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int resultQuery = 0;

    private Data data;

    public Respuesta(Data data) {
        this.data = data;
    }

    public void sendRespuesta(String pregunta, Ventana ventana) {
        if (!pregunta.equalsIgnoreCase("")) {
            ventana.getTextArea().append(data.getTab() + getRespuestaFrecuencia(pregunta) + "\n");
            System.out.println(data.getTab() + getRespuestaFrecuencia(pregunta));
        } else {
            ventana.getTextArea().append(data.getTab() + "Dime ave");
            System.out.println("                         " + "Dime ave");
        }
    }

    public void pregunta(String pregunta) {
        if (!pregunta.equalsIgnoreCase("")) {
            System.out.println("                         " + getRespuestaFrecuencia(pregunta));
        } else {
            System.out.println("                         " + "Dime ave");
        }
    }

    public String getRespuesta(String pregunta) {
        resultQuery = 0;
        try {
            connection = getConnection();
            String sql = "SELECT respuesta FROM PreguntasYRespuestas "
                    + "where pregunta like '%" + pregunta + "%' order by valoracionRespuesta desc";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("respuesta");
            } else {
                //registrar Respuestas
                return "No tengo respuestas a esa pregunta";
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

    public String getRespuestaFrecuencia(String pregunta) {
        resultQuery = 0;
        try {
            connection = getConnection();
            String sql = "SELECT respuesta FROM PreguntasYRespuestas "
                    + "where pregunta like '%" + pregunta + "%' order by frecuenciaPregunta desc";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("respuesta");
            } else {
                return "No tengo respuestas a esa pregunta";
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

    public String getRespuestaCoincidencia(String pregunta) {
        resultQuery = 0;
        try {
            connection = getConnection();
            String sql = "SELECT respuesta FROM PreguntasYRespuestas "
                    + "where pregunta like '%" + pregunta + "%' order by pregunta desc";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("respuesta");
            } else {
                return "No tengo respuestas a esa pregunta";
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

    public String getCoincidencia(String pregunta) {
        resultQuery = 0;
        try {
            connection = getConnection();
            String sql = "SELECT pregunta FROM PreguntasYRespuestas "
                    + "where pregunta like '%" + pregunta + "%'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String preguntaRs = resultSet.getString("pregunta");
            }
        } catch (SQLException sqlException) {
            super.printException(sqlException);
            return sqlException.getMessage();
        } finally {
            super.closeConnection(connection);
            super.closePreparedStatement(preparedStatement);
            super.closeResultSet(resultSet);
        }
        return null;

    }

    public String getCoincidencia2(String pregunta) {
        return null;
    }

    public static void main(String[] args) {
        String pregunta = "Hola";
        String preguntaBD = "Hola";

        System.out.println("Pregunta: " + pregunta);
        System.out.println("PreguntaBD: " + preguntaBD);

        int contador = 0;

        final int PORCs = 100;
        int caracteres = 0;
        int total = 0;

        char arrayPregunta[] = pregunta.toCharArray();
        char arrayPreguntaBD[] = preguntaBD.toCharArray();

        System.out.println("Tamaño = " + arrayPregunta.length);

        for (int i = 0; i < arrayPregunta.length; i++) {

            for (int j = 0; j < arrayPreguntaBD.length; j++) {
                if (arrayPregunta[i] == arrayPreguntaBD[j]) {
                    System.out.println(arrayPregunta[i] + " == " + arrayPreguntaBD[j]);
                    contador++;
                }
            }
        }

        System.out.println("Clantidad de caracteres iguales: " + contador);

        System.out.println("");

        caracteres = contador;
        total = arrayPreguntaBD.length;
        System.out.println(caracteres);
        System.out.println(total);
        int porc = caracteres * PORCs / total;
        System.out.println("Porcentaje = " + porc);

    }

}
