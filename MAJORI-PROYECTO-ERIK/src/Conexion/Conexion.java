/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mario V
 */
public class Conexion {

    Connection con = null;

    public Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdventas", "root", "1234");
        } catch (ClassNotFoundException e) {
            System.err.print(e.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            return con;
        }
    }

}
