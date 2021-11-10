/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3Grupo.Reto3;
//Interface Categoria que nos permitira el uso del repositorio de spring en nuestra aplicación

//Librerias necesarias para la relaciones, persistencias, inserciones, etc.
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Camilo Andres Silva A.
 */
//Declaración de la interface categoria junto con el nombre de la clase principal y el tipo de dato de la llave primaria
public interface InterfaceCategoria extends CrudRepository<Categoria, Integer> {

}
