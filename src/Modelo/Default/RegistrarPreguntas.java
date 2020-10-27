/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Default;

import Modelo.Connection.ConnectionAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diosl
 */
public class RegistrarPreguntas extends ConnectionAccess {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int resultQuery = 0;

    public void registrarPregunta(String pregunta) {
        resultQuery = 0;
        try {
            connection = getConnection();
            String sql = "INSERT INTO PreguntasYRespuestas (pregunta, respuesta) values (?,?)"; //ERROR
            preparedStatement.setString(1, "");
            preparedStatement.setString(2, "");
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException sqlException) {
            super.printException(sqlException);
        } finally {
            super.closeConnection(connection);
            super.closePreparedStatement(preparedStatement);
            super.closeResultSet(resultSet);
        }
    }
}
