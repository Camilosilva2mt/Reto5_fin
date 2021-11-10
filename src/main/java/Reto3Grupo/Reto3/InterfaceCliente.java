/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3Grupo.Reto3;
//Interface Cliente que nos permitira el uso del repositorio de spring en nuestra aplicación

//Librerias necesarias para la relaciones, persistencias, inserciones, etc.
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Camilo Andres Silva A.
 */
//Declaración de la interface cliente junto con el nombre de la clase principal y el tipo de dato de la llave primaria
public interface InterfaceCliente extends CrudRepository<Cliente, Integer> {

}
