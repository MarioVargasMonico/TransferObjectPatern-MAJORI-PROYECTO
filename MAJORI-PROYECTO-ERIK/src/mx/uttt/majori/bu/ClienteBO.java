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
        ClienteVO cli = (ClienteVO)(obj);
        //String query = "{call InsertarCliente(?,?,?)}";
        try {
            Connection con  = new Conexion().obtenerConexion();
            CallableStatement cs = con.prepareCall("{call InsertarCliente(?,?,?)}");
            //CallableStatement cStmt = conn.prepareCall("{call demoSp(?, ?)}");
            cs.setString(1, cli.getNombre());
            cs.setString(2, cli.getApellidos());
            cs.setString(3, cli.getTelefono());
            cs.execute();
            con.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() +"Error en la llamada al procedure ");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(ClienteVO obj) {
      ClienteVO cli = (ClienteVO)(obj);
      Connection con = new Conexion().obtenerConexion();
      String query = "call eliminarCliente(?)";
        try {
            PreparedStatement cs = con.prepareCall(query);
            cs.setInt(1, cli.getIDCliente());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(ClienteVO obj) {
        ClienteVO cli = (ClienteVO)(obj);
        String query = "call actualizarCliente(?,?,?)";
        try {
            Connection con = new Conexion().obtenerConexion();
            CallableStatement cs = con.prepareCall(query);
            
            
            cs.setString(2, cli.getNombre());
            cs.setString(3, cli.getApellidos());
            
            cs.setString(4, cli.getTelefono());
            cs.executeUpdate();
            
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<ClienteVO> consultarTodo() {
        ArrayList<ClienteVO> listacli = new ArrayList<ClienteVO>();
        CallableStatement cst;
        ResultSet rs;
        Connection con = new Conexion().obtenerConexion();
        try {
            cst = con.prepareCall("{ call obtenerCliente() }");
            rs = cst.executeQuery();
            while (rs.next()) {                
                ClienteVO cli = new ClienteVO();
                
            cli.setIDCliente(rs.getInt("IDCliente"));
            cli.setNombre(rs.getString("Nombre"));
            cli.setApellidos(rs.getString("Apellidos"));
            
            cli.setTelefono(rs.getString("Telefono"));
                 
                listacli.add(cli);
            }
        } catch (SQLException ex) {
            System.err.println("Error " + ex.getMessage());
        }
        return listacli;
    }

    @Override
    public ArrayList<ClienteVO> consultar(ClienteVO obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
}
    
