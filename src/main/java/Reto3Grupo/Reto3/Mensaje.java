/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Mensaje donde se instancian atributos y metodos set and get de cada uno

/**
 *
 * @author Camilo Andres Silva A.
 */
//Librerias necesarias para la relaciones, persistencias, inserciones, etc.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//Anotaciones JPA

@Entity//Declaración para indicar que una clase java representa una tabla en la base de datos
@Table(name = "message")//Nombre de la tabla a realizar las inserciones
//Clase mensaje serializable
public class Mensaje implements Serializable {

    @Id//Representacion para la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generación automatica de la llave primaria
    private Integer idMessage;//Variable que corresponde al atributo id de la tabla mensaje
    private String messageText;//Variable que corresponde al atributo mensaje de la tabla mensaje
    //Declaración de las relaciones de la tabla mensaje
    //Declaración de la relación muchos a uno de la clase cuatrimotos con la clase mensajes
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Quadbike quadbike;
    //Declaración de la relación muchos a uno de la clase cliente con la clase mensajes
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Cliente client;

    //Metodo get del atributo id retorna el id del mensajes
    public Integer getIdMessage() {
        return idMessage;
    }

    //Metodo set del atributo id del mensaje
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    //Metodo get del atributo mensaje retorna el texto del mensaje
    public String getMessageText() {
        return messageText;
    }

    //Metodo set del atributo texto del mensaje
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    //Metodo get del atributo cuatrimoto retorna la cuatrimoto asociadas al mensaje
    public Quadbike getQuadbike() {
        return quadbike;
    }

    //Metodo set del atributo cuatrimoto asociado al mensaje
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    //Metodo get del atributo cliente retorna el cliente asociado al mensaje
    public Cliente getClient() {
        return client;
    }

    //Metodo set del atributo cliente asociado al mensaje
    public void setClient(Cliente client) {
        this.client = client;
    }
}
