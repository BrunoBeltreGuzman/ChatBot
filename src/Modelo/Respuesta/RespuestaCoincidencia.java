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
import java.util.ArrayList;

/**
 *
 * @author diosl
 */
public class RespuestaCoincidencia extends ConnectionAccess implements IRespuesta {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int resultQuery = 0;

    private Ventana ventana;
    private Data data;

    public RespuestaCoincidencia(Ventana ventana, Data data) {
        this.ventana = ventana;
        this.data = data;
    }

    @Override
    public void sendRespuesta(String pregunta, Ventana ventana) {
        if (!pregunta.equalsIgnoreCase("")) {
            String respuesta = respuesta(pregunta);
            if (respuesta != null) {
                ventana.getTextArea().append(data.getTab() + respuesta + "\n");
            } else {
                Default.sendRespuestaDefault(ventana, data);
            }
        } else {
            Default.sendRespuestaDefault(ventana, data);
        }
    }

    public String respuesta(String pregunta) {
        ArrayList<Data> list = listPreguntas(pregunta);

        if (list != null) {
            int pocentajes[] = null;
            String respuestas[] = null;

            int mayorPor = 0;
            String mayorRes = null;

            for (int i = 0; i < list.size(); i++) {
                pocentajes[i] = getPorcentaje(pregunta, list.get(i).getPregunta());
                respuestas[i] = list.get(i).getRespuesta();
            }

            mayorPor = pocentajes[0];

            for (int i = 0; i < pocentajes.length; i++) {
                if (pocentajes[i] > mayorPor) {
                    mayorPor = pocentajes[i];
                    mayorRes = respuestas[i];
                }
            }
            return mayorRes;
        } else {
            return null;
        }

    }

    public ArrayList<Data> listPreguntas(String pregunta) {
        resultQuery = 0;
        try {
            ArrayList<Data> list = new ArrayList();
            connection = getConnection();
            String sql = "SELECT pregunta, respuesta FROM PreguntasYRespuestas "
                    + "where pregunta like '%" + pregunta + "%'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                while (resultSet.next()) {
                    Data data2 = new Data();
                    data2.setPregunta(resultSet.getString("pregunta"));
                    data2.setRespuesta(resultSet.getString("respuesta"));
                    list.add(data2);
                }
                return list;
            } else {
                return null;
            }
        } catch (SQLException sqlException) {
            super.printException(sqlException);
            return null;
        } finally {
            super.closeConnection(connection);
            super.closePreparedStatement(preparedStatement);
            super.closeResultSet(resultSet);
        }
    }

    @Override
    public String getRespuesta(String pregunta) {
        return null;
    }

    public int getPorcentaje(String pregunta, String preguntaBD) {
        String originPregunta = pregunta;
        String originPreguntaBD = preguntaBD;

        preguntaBD = preguntaBD.trim();
        preguntaBD = preguntaBD.replaceAll(" ", "");

        pregunta = pregunta.trim();
        pregunta = pregunta.replaceAll(" ", "");

        pregunta = pregunta.toLowerCase();
        preguntaBD = preguntaBD.toLowerCase();

        System.out.println("Pregunta: " + originPregunta);
        System.out.println("PreguntaBD: " + originPreguntaBD);

        final int PORC = 100;
        int caracteresIguales = 0;
        int totalDeCaracteres = 0;

        int contador = 0;

        char arrayPregunta[] = pregunta.toCharArray();
        char arrayPreguntaBD[] = preguntaBD.toCharArray();

        for (int i = 0; i < arrayPregunta.length; i++) {

            for (int j = 0; j < arrayPreguntaBD.length; j++) {
                if (arrayPregunta[i] == arrayPreguntaBD[j]) {
                    System.out.println(j + ") " + arrayPregunta[i] + " == " + arrayPreguntaBD[j]);
                    contador++;
                }
            }
        }

        caracteresIguales = contador;
        totalDeCaracteres = arrayPreguntaBD.length;
        int porcentaje = caracteresIguales * PORC / totalDeCaracteres;

        System.out.println("Caracteres igulales (pregunta): " + caracteresIguales);
        System.out.println("Total de caracteres (preguntaBD): " + totalDeCaracteres);

        return porcentaje;
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
