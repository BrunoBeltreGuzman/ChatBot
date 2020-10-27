/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diosl
 */
public interface IConnection {

    public boolean conectar();

    public boolean desconectar();

    public Connection getConnection();

    public boolean conectarToTransaccion();

    public boolean desconectarToTransaccion();

    public Connection getConnectionToTransaccion();

    public boolean closeConnection(Connection connection);

    public boolean closePreparedStatement(PreparedStatement preparedStatement);

    public boolean closeResultSet(ResultSet resultSet);

    public boolean printException(SQLException sqlException);

    public boolean printException(SQLException sqlException, String message);
}
