/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Contador clientes donde se instancian atributos y metodos para el conteo de los clientes
/**
 *
 * @author Camilo Andres Silva A.
 */
//Clase contador de clientes
public class ContadorClientes {
    private Long total;
    private Cliente client;

    //Metodo constructor de la clase
    public ContadorClientes(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }
    //Metodo get del atributo total
    public Long getTotal() {
        return total;
    }
    //Metodo set del atributo total
    public void setTotal(Long total) {
        this.total = total;
    }
    //Metodo get del atributo Cliente
    public Cliente getClient() {
        return client;
    }
    //Metodo set del atributo cliente
    public void setClient(Cliente client) {
        this.client = client;
    }
    
}
