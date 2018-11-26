/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfas.IOperaciones;
import java.util.ArrayList;
import mx.uttt.majori.VO.ClienteVO;
import mx.uttt.majori.bu.ClienteBO;

/**
 *
 * @author Ricardo Hiram
 */
public class CtrlCliente implements IOperaciones<ClienteVO>{

    @Override
    public boolean Insertar(ClienteVO obj) {
        return new ClienteBO().Insertar(obj);
    }

    public boolean eliminar(ClienteVO obj) {
       return new ClienteBO().eliminar(obj);
    }

    public boolean actualizar(ClienteVO obj) {
       return new ClienteBO().actualizar(obj);
    }

    public ArrayList<ClienteVO> consultarTodo() {
        return new ClienteBO().consultarTodo();
    }

    

   
    
}
