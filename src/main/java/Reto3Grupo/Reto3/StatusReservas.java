/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Estado de las reservas donde se instancian atributos y metodos para el conteo de las reservas

/**
 *
 * @author Camilo Andres Silva A.
 */
//Clase Estado de reservas
public class StatusReservas {

    private int completed; //Variable para almacenar la cantidad de reservas completadas
    private int cancelled; //Variable para almacenar la cantidad de reservas canceladas

    //Metodo constructor de la clase
    public StatusReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    //Metodo get para las reservas completadas
    public int getCompleted() {
        return completed;
    }

    //Metodo set para las reservas completadas
    public void setCompleted(int completed) {
        this.completed = completed;
    }

    //Metodo get para las reservas canceladas
    public int getCancelled() {
        return cancelled;
    }

    //Metodo set para las reservas canceladas
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

}
