/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Cliente donde se instancian atributos y metodos set and get de cada uno

/**
 *
 * @author Camilo Andres Silva A.
 */
//Librerias necesarias para la relaciones, persistencias, inserciones, etc.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//Anotaciones JPA

@Entity//Declaración para indicar que una clase java representa una tabla en la base de datos
@Table(name = "client")//Nombre de la tabla a realizar las inserciones

//Clase cliente serializable
public class Cliente implements Serializable {

    @Id//Representacion para la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generación automatica de la llave primaria
    private Integer idClient;//Variable que corresponde al atributo id de la tabla cliente
    private String email;//Variable que corresponde al atributo correo electronico de la tabla cliente
    private String password;//Variable que corresponde al atributo clave de la tabla cliente
    private String name;//Variable que corresponde al atributo nombre de la tabla cliente
    private Integer age;//Variable que corresponde al atributo edad de la tabla cliente

    //Declaración de las relaciones de la tabla cliente
    //Declaración de la relación uno a muchos de la clase cliente con la clase mensajes
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Mensaje> messages;

    //Declaración de la relación uno a muchos d ela clase cliente con la clase reservaciones
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservaciones> reservations;

    //Metodo get del atributo id retorna el id del cliente
    public Integer getIdClient() {
        return idClient;
    }

    //Metodo set del atributo id
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    //Metodo get del atributo email retorna el email del cliente
    public String getEmail() {
        return email;
    }

    //Metodo set del atributo email
    public void setEmail(String email) {
        this.email = email;
    }

    //Metodo get del atributo clave retorna la clave del cliente
    public String getPassword() {
        return password;
    }

    //Metodo set del atributo clave
    public void setPassword(String password) {
        this.password = password;
    }

    //Metodo get del atributo nombre retorna el nombre del cliente
    public String getName() {
        return name;
    }

    //Metodo set del atributo nombre
    public void setName(String name) {
        this.name = name;
    }

    //Metodo get del atributo edad retorna la edad del cliente
    public Integer getAge() {
        return age;
    }

    //Metodo set del atributo edad
    public void setAge(Integer age) {
        this.age = age;
    }

    //Metodo get del atributo mensaje retorna los mensajes asociados al cliente
    public List<Mensaje> getMessages() {
        return messages;
    }

    //Metodo set del atributo mensajes
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    //Metodo get del atributo reservas retorna las reservas asociadas al cliente
    public List<Reservaciones> getReservations() {
        return reservations;
    }

    //Metodo set del atributo reservas
    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
}
