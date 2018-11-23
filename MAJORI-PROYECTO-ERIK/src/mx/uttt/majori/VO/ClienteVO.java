/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uttt.majori.VO;

/**
 *
 * @author Jose&
 */
public class ClienteVO {

    private int IDCliente;
    private String Nombre;
    private String Apellidos;
    private String Telefono;

    public ClienteVO(int IDCiente, String Nombre, String Apellidos, String Telefono) {
        this.IDCliente = IDCliente;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
    }

    /**
     * @return the IDCliente
     */
    public int getIDCliente() {
        return IDCliente;
    }

    /**
     * @param IDCliente the IDCliente to set
     */
    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

}
