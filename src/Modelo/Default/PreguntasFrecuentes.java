/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Default;

import Modelo.Connection.ConnectionAccess;
import Modelo.DataDAO.Data;
import Modelo.Pregunta.Pregunta;
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
public class PreguntasFrecuentes extends ConnectionAccess {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int resultQuery = 0;
    private Data data;

    public PreguntasFrecuentes(Data data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
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
}
