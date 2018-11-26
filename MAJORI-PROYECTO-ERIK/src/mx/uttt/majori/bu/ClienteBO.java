/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uttt.majori.bu;

import Conexion.Conexion;
import Interfas.IOperaciones;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.uttt.majori.VO.ClienteVO;

/**
 *
 * @author Ricardo Hiram
 */
public class ClienteBO implements IOperaciones<ClienteVO> {
    


    @Override
    public boolean Insertar(ClienteVO obj) {
        
          PreparedStatement pst;
        Connection con = new Conexion().obtenerConexion();
        String query = "INSERT INTO cliente (Nombre, Apellidos, Telefono) VALUES (?,?,?)";
        try {
            pst=con.prepareStatement(query);
            pst.setString(1, obj.getNombre());
            pst.setString(2, obj.getApellidos());
             pst.setString(3, obj.getTelefono());
            //System.out.println(pst.executeUpdate());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {

        }
        return true;
    }
//        ClienteVO cli = (ClienteVO)(obj);
//        //String query = "{call InsertarCliente(?,?,?)}";
//        try {
//            Connection con  = new Conexion().obtenerConexion();
//            CallableStatement cs = con.prepareCall("{call InsertarCliente(?,?,?)}");
//            //CallableStatement cStmt = conn.prepareCall("{call demoSp(?, ?)}");
//            cs.setString(1, cli.getNombre());
//            cs.setString(2, cli.getApellidos());
//            cs.setString(3, cli.getTelefono());
//            cs.execute();
//            con.close();
//            return true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage() +"Error en la llamada al procedure ");
//            System.out.println(e.getMessage());
//            return false;
//        }
    

    @Override
    public boolean eliminar(ClienteVO obj) {
      ClienteVO cli = (ClienteVO)(obj);
      PreparedStatement pst;
        Connection con = new Conexion().obtenerConexion();
        String query = "DELETE FROM cliente WHERE Nombre=?";
        try {
            pst=con.prepareStatement(query);
            pst.setString(1, obj.getNombre());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {

        }
        return true;
        
    }
    

    @Override
    public boolean actualizar(ClienteVO obj) {
       PreparedStatement pst;
        Connection con = new Conexion().obtenerConexion();
        String query="UPDATE cliente SET Telefono=?, Apellidos=? WHERE Nombre=?";
        
        try {
            pst=con.prepareStatement(query);
            pst.setString(1, obj.getTelefono());
            pst.setString(2, obj.getApellidos());
            pst.setString(3, obj.getNombre());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {

        }
        return true;
    }

    @Override
    public ArrayList<ClienteVO> consultarTodo() {
         ArrayList<ClienteVO> listape = new ArrayList<ClienteVO>();
        PreparedStatement cst;
        Connection con = new Conexion().obtenerConexion();

        ResultSet rs;
        try {
           cst = con.prepareStatement("SELECT IDCliente, Nombre, Apellidos, Telefono FROM cliente");
            rs = cst.executeQuery();
            while (rs.next()) {
                ClienteVO cli= new ClienteVO();
                System.out.println(cli.getIDCliente()+" "+cli.getNombre()+" "+cli.getApellidos()+" "+cli.getTelefono());
                cli.setIDCliente(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setTelefono(rs.getString(4));
                listape.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            
        }
        return listape;
    }


    
  
}
    
