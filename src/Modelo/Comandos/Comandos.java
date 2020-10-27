/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Comandos;

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
public class Comandos extends ConnectionAccess {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int resultQuery = 0;

    private String[] cmdComandos = {
        "do-preguntas-f",
        "do-limpiar",
        "do-cerrar",
        "do-preguntas-v"
    };

    private Data data;

    public Comandos(Data data) {
        this.data = data;
    }

    public void cmd(String comando, Ventana ventana) {
        if (comando == cmdComandos[0]) {
            doPreguntasFrecuentes(ventana);
        } else {
            if (comando == cmdComandos[1]) {
                doLimpiar(ventana);
            } else {
                if (comando == cmdComandos[2]) {
                    doCerrar(ventana);
                } else {
                    if (comando == cmdComandos[3]) {
                        doPreguntasValoradas(ventana);
                    } else {
                        Default.sendRespuestaDefault(ventana, data);
                    }
                }
            }
        }
    }

    public void doPreguntasFrecuentes(Ventana ventana) {
        ArrayList<Data> list = listPreguntasFrecuentes();

        for (int i = 0; i < list.size(); i++) {
            ventana.getTextArea().append(list.get(i).getPregunta() + "\n");
            ventana.getTextArea().append(list.get(i).getRespuesta() + "\n" + "\n");
        }
    }

    public ArrayList<Data> listPreguntasFrecuentes() {
        resultQuery = 0;
        try {
            ArrayList<Data> list = new ArrayList();
            connection = getConnection();
            String sql = "SELECT pregunta, respuesta FROM PreguntasYRespuestas "
                    + "order by frecuenciaPregunta desc";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Data data2 = new Data();
                data2.setPregunta(resultSet.getString("pregunta"));
                data2.setRespuesta(resultSet.getString("respuesta"));
                list.add(data2);
            }
            return list;
        } catch (SQLException sqlException) {
            super.printException(sqlException);
            return null;
        } finally {
            super.closeConnection(connection);
            super.closePreparedStatement(preparedStatement);
            super.closeResultSet(resultSet);
        }
    }

    public void doPreguntasValoradas(Ventana ventana) {
        ArrayList<Data> list = listPreguntasValoradas();

        for (int i = 0; i < list.size(); i++) {
            ventana.getTextArea().append(list.get(i).getPregunta() + "\n");
            ventana.getTextArea().append(list.get(i).getRespuesta() + "\n" + "\n");
        }
    }

    public ArrayList<Data> listPreguntasValoradas() {
        resultQuery = 0;
        try {
            ArrayList<Data> list = new ArrayList();
            connection = getConnection();
            String sql = "SELECT pregunta, respuesta FROM PreguntasYRespuestas "
                    + "order by valoracionRespuesta desc";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Data data2 = new Data();
                data2.setPregunta(resultSet.getString("pregunta"));
                data2.setRespuesta(resultSet.getString("respuesta"));
                list.add(data2);
            }
            return list;
        } catch (SQLException sqlException) {
            super.printException(sqlException);
            return null;
        } finally {
            super.closeConnection(connection);
            super.closePreparedStatement(preparedStatement);
            super.closeResultSet(resultSet);
        }
    }

    public void doLimpiar(Ventana ventana) {
        ventana.getTextArea().setText("");
        ventana.getTextMessage().setText("");
    }

    public void doCerrar(Ventana ventana) {
        ventana.dispose();
    }

}
