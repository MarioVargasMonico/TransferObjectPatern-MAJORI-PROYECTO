/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfas;

import java.util.ArrayList;

/**
 *
 * @author Ricardo Hiram
 */

    public interface IOperaciones<Generico> {
    boolean Insertar(Generico obj);
    boolean eliminar (Generico obj);
    boolean actualizar (Generico obj);
    ArrayList<Generico>consultarTodo();
     ArrayList<Generico>consultar(Generico obj);
}
    

