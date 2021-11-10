/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Respositorio Mensaje donde se implmenta lo concreot de la persistencia con el framework
//Librerias necesarias para la relaciones, persistencias, inserciones, etc.

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Camilo Andres Silva A.
 */
@Repository//Anotación que identifica la clase como un repositorio
//Clase repositorio mensaje
public class RepositorioMensaje {

    @Autowired//Anotación para la inyección de dependencias
    private InterfaceMensaje crud3;//Declaración de la variable proveniente de la interface para su uso

    //Metodo get para la obtención de la lista de mensajes con la ayuda de la interface
    public List<Mensaje> getAll() {
        return (List<Mensaje>) crud3.findAll();
    }

    //Metodo get para la obtención del mensaje por medio del id con la ayuda de la interface
    public Optional<Mensaje> getMessage(int id) {
        return crud3.findById(id);
    }

    //Metodo grabar mensaje con la ayuda de la interface
    public Mensaje save(Mensaje message) {
        return crud3.save(message);
    }

    //Metodo eliminar mensaje con la ayuda de la interface
    public void delete(Mensaje message) {
        crud3.delete(message);
    }
}
