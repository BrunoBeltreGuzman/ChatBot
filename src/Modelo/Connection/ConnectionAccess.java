/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author diosl
 */
public class ConnectionAccess implements IConnection {

    private Connection connectionThis;
    private Connection connectionToTransaccionThis;

    private String URL;

    public ConnectionAccess() {

        //URL: jdbc Driver//File1//File2//File3...//DataBaseName.accdb
        this.URL = "jdbc:ucanaccess://C://DataBase//BDChatBot.accdb";
        conectar();
        conectarToTransaccion();
    }

    @Override
    public boolean conectar() {
        try {
            connectionThis = DriverManager.getConnection(URL);
            return true;
        } catch (SQLException sqlException) {
            printException(sqlException);
            return false;
        }
    }

    @Override
    public boolean desconectar() {
        try {
            this.connectionThis.close();
            return true;
        } catch (SQLException sqlException) {
            printException(sqlException);
            return false;
        }
    }

    @Override
    public Connection getConnection() {
        conectar();
        if (connectionThis != null) {
            return connectionThis;
        } else {
            return null;
        }
    }

    @Override
    public boolean conectarToTransaccion() {
        try {
            connectionToTransaccionThis = DriverManager.getConnection(URL);
            connectionToTransaccionThis.setAutoCommit(false);
            return true;
        } catch (SQLException sqlException) {
            printException(sqlException);
            return false;
        }
    }

    @Override
    public boolean desconectarToTransaccion() {
        try {
            this.connectionToTransaccionThis.close();
            return true;
        } catch (SQLException sqlException) {
            printException(sqlException);
            return false;
        }
    }

    @Override
    public Connection getConnectionToTransaccion() {
        conectarToTransaccion();
        if (connectionToTransaccionThis != null) {
            return connectionToTransaccionThis;
        } else {
            return null;
        }
    }

    @Override
    public boolean closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                return true;
            } catch (SQLException sqlException) {
                printException(sqlException);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                return true;
            } catch (SQLException sqlException) {
                printException(sqlException);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
                return true;
            } catch (SQLException sqlException) {
                printException(sqlException);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean printException(SQLException sqlException) {
        if (sqlException != null) {
            JOptionPane.showMessageDialog(null, "SQL Exception: " + sqlException.getMessage(), "SQL Exception", ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "SQL Exception: " + sqlException, "SQL Exception", ERROR_MESSAGE);
            sqlException.printStackTrace();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean printException(SQLException sqlException, String message) {
        if (message != null && sqlException != null) {
            JOptionPane.showMessageDialog(null, message, "SQL Exception", ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "SQL Exception: " + sqlException.getMessage(), "SQL Exception", ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "SQL Exception: " + sqlException, "SQL Exception", ERROR_MESSAGE);
            sqlException.printStackTrace();
            return true;
        } else {
            return false;
        }
    }
}
