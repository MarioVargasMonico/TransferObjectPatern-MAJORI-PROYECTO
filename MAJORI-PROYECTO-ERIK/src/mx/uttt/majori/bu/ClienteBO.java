/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uttt.majori.bu;

    
import com.mysql.jdbc.EscapeTokenizer;
    import java.util.ArrayList;
    import java.util.List;
import mx.uttt.majori.VO.ClienteVO;
/**
 *
 * @author Ricardo Hiram
 */
public class ClienteBO {

    List<ClienteVO> Clientes;
    
    public ClienteBO(){
    Clientes = new ArrayList<ClienteVO>();
    
    ClienteVO clienten= new ClienteVO(0, Nombre, Apellidos, Telefono);
    
    }
    
    
    public void deleteClient(ClienteVO cliente){
    Clientes.remove(cliente.setNombre());
        System.out.println("EL CLIENTE SE HA ELIMINADO CORRECTAMENTE");
    }
    
    public void updateStudent(ClienteVO cliente ){
        Clientes.get(cliente.getNombre()).setNombre(cliente.getNombre()));
        System.out.println("EL CLIENTE HA SIDO ACTUALZADO");
  }
    
    public  List<ClienteVO>getAllClientes(){
    return Clientes;
    }
}


