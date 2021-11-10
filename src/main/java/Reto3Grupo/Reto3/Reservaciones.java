/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Reservaciones donde se instancian atributos y metodos set and get de cada uno

/**
 *
 * @author Camilo Andres Silva A.
 */
//Librerias necesarias para la relaciones, persistencias, inserciones, etc.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//Anotaciones JPA

@Entity//Declaración para indicar que una clase java representa una tabla en la base de datos
@Table(name = "reservation")//Nombre de la tabla a realizar las inserciones

//Clase reservaciones serializable
public class Reservaciones implements Serializable {

    @Id//Representacion para la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generación automatica de la llave primaria
    private Integer idReservation;//Variable que corresponde al atributo id de la tabla reservación
    private Date startDate;//Variable que corresponde al atributo dia de inicio de la reserva
    private Date devolutionDate;//Variable que corresponde al atributo dia fin de la reserva
    private String status = "created";//Variable que corresponde al estado de la reserva

    //Declaración de las relaciones de la tabla reservaciones
    //Declaración de la relación muchos a uno de la clase reservaciones con la clase cuatrimoto
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Quadbike quadbike;
    //Declaración de la relación muchos a uno de la clase mensajes con la clase reservaciones
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Cliente client;

    private String score;//Variable que acumula el puntaje de calificación de cada reserva
    //Metodo get del atributo id retorna el id de la reservación

    public Integer getIdReservation() {
        return idReservation;
    }

    //Metodo set del atributo reservación
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    //Metodo get del atributo dia de inicio retorna la fecha de inicio de la reservación

    public Date getStartDate() {
        return startDate;
    }

    //Metodo set del atributo dia inicio de la reserva
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    //Metodo get del atributo dia de devolución retorna la fecha de devolución de la reservación

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    //Metodo set del atributo dia de devolución de la reserva
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    //Metodo get del atributo estado retorna el estado de la reservación

    public String getStatus() {
        return status;
    }

    //Metodo set del atributo estado de la reserva
    public void setStatus(String status) {
        this.status = status;
    }

    //Metodo get del atributo cuatrimoto retorna la cuatrimoto asociada a la reservación
    public Quadbike getQuadbike() {
        return quadbike;
    }

    //Metodo set del atributo cuatrimoto asociada a la reserva
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    //Metodo get del atributo cliente retorna el cliente asociado a la reservación
    public Cliente getClient() {
        return client;
    }

    //Metodo set del atributo cliente asociado a la reserva
    public void setClient(Cliente client) {
        this.client = client;
    }

    //Metodo get del atributo puntaje retorna el puntaje de la calificación de la reservación
    public String getScore() {
        return score;
    }

    //Metodo set del atributo puntaje de la calificación de la reserva
    public void setScore(String score) {
        this.score = score;
    }

}
