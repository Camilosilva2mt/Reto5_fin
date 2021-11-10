/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Cuatrimoto donde se instancian atributos y metodos set and get de cada uno

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//Anotaciones JPA

@Entity//Declaración para indicar que una clase java representa una tabla en la base de datos
@Table(name = "quadbike")//Nombre de la tabla a realizar las inserciones
//Clase cuatrimoto serializable
public class Quadbike implements Serializable {

    @Id//Representacion para la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generación automatica de la llave primaria
    private Integer id;//Variable que corresponde al atributo id de la tabla cuatrimoto
    private String name;//Variable que corresponde al atributo nombre de la tabla cuatrimoto
    private String brand;//Variable que corresponde al atributo marca de la tabla cuatrimoto
    private Integer year;//Variable que corresponde al atributo año de la tabla cuatrimoto
    private String description;//Variable que corresponde al atributo descripción de la tabla cuatrimoto
    //Declaración de las relaciones de la tabla cuatrimoto
    //Declaración de la relación uno a uno de la tabla cuatrimoto con la clase categoria    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("quadbikes")
    private Categoria category;
    //Declaración de la relación uno a muchos de la clase cuatrimoto con la clase cliente
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Mensaje> messages;
    //Declaración de la relación uno a muchos de la clase cuatrimoto con la clase reservaciones
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Reservaciones> reservations;

    //Metodo get del atributo id retorna el id de la cuatrimoto
    public Integer getId() {
        return id;
    }

    //Metodo set del atributo id
    public void setId(Integer id) {
        this.id = id;
    }

    //Metodo get del atributo id retorna el id de la cuatrimoto
    public String getName() {
        return name;
    }

    //Metodo set del atributo nombre
    public void setName(String name) {
        this.name = name;
    }

    //Metodo get del atributo marca retorna la marca de la cuatrimoto
    public String getBrand() {
        return brand;
    }

    //Metodo set del atributo marca
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //Metodo get del atributo año retorna el año de la cuatrimoto
    public Integer getYear() {
        return year;
    }

    //Metodo set del atributo año
    public void setYear(Integer year) {
        this.year = year;
    }

    //Metodo get del atributo descripción retorna la descripción de la cuatrimoto
    public String getDescription() {
        return description;
    }

    //Metodo set del atributo descripción
    public void setDescription(String description) {
        this.description = description;
    }

    //Metodo get del atributo categoria retorna la categoria de la cuatrimoto
    public Categoria getCategory() {
        return category;
    }

    //Metodo set del atributo categoria
    public void setCategory(Categoria category) {
        this.category = category;
    }

    //Metodo get del atributo mensaje retorna los mensajes asociados a la cuatrimoto
    public List<Mensaje> getMessages() {
        return messages;
    }

    //Metodo set del atributo mensajes
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    //Metodo get del atributo reservaciones retorna las resevas asociadas a la cuatrimoto
    public List<Reservaciones> getReservations() {
        return reservations;
    }

    //Metodo set del atributo reservas
    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }

}
