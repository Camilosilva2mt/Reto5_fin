/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Categoria donde se instancian atributos y metodos set and get de cada uno

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
@Table(name = "category")//Nombre de la tabla a realizar las inserciones
//Clase categoria serializable
public class Categoria implements Serializable {

    @Id//Representacion para la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generación automatica de la llave primaria
    private Integer id;//Variable que corresponde al atributo id de la tabla categoria
    private String name;//Variable que corresponde al atributo nombre de la tabla categoria
    private String description;//Variable que corresponde al atributo descripción de la tabla categoria

    //Declaración de las relaciones de la tabla categoria
    //Declaración de la relación uno a muchos de la clase categoria con la clase cuatrimotos
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Quadbike> Quadbikes;
    //Metodo get del atributo id retorna el id de la categoria

    public Integer getId() {
        return id;
    }

    //Metodo set del atributo id
    public void setId(Integer id) {
        this.id = id;
    }

    //Metodo get del atributo nombre retorna el nombre de la categoria
    public String getName() {
        return name;
    }

    //Metodo set del atributo nombre
    public void setName(String name) {
        this.name = name;
    }

    //Metodo get del atributo descripción retorna la descripción de la categoria
    public String getDescription() {
        return description;
    }

    //Metodo set del atributo descripción
    public void setDescription(String description) {
        this.description = description;
    }

    //Metodo get del atributo cuatrimoto retorna las cuatrimotos asociadas a la categoria
    public List<Quadbike> getQuadbikes() {
        return Quadbikes;
    }

    //Metodo set del atributo cuatrimotos
    public void setQuadbikes(List<Quadbike> Quadbikes) {
        this.Quadbikes = Quadbikes;
    }

}
