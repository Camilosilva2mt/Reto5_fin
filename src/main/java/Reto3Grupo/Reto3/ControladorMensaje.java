/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase controladora de la clase Mensaje donde se instancian los rest para controlar las acciones de la api (POST, GET, PUT Y DELETE)
//Librerias necesarias para la relaciones, persistencias, inserciones, etc.

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Camilo Andres Silva A.
 */
@RestController//Anotación de spring para controlar la clase
@RequestMapping("/api/Message")//Anotación para relacionar un metodo con una petición http
//Anotación para el control de los metodos GET, POST, PUT y DELETE de la aplicación
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

//Declaración de la clase
public class ControladorMensaje {

    @Autowired//Anotación para la inyección de dependencias
    private ServiciosMensaje servicio;//Declaración de la variable proveniente del servicio para su uso

    //Metodo para la obtención de la lista de mensajes por medio del servicio
    @GetMapping("/all")//Anotación para el manejo de los metodos get
    public List<Mensaje> getMessages() {
        return servicio.getAll();
    }

    //Metodo para la obtención de la lista de mensajes por el id medio del servicio
    @GetMapping("/{id}")//Anotación para el manejo de los metodos get
    public Optional<Mensaje> getMessage(@PathVariable("id") int messageId) {
        return servicio.getMessage(messageId);
    }

    //Metodo para grabar la información de mensajes por medio del servicio
    @PostMapping("/save")//Anotación para el manejo de los metodos post
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje message) {
        return servicio.save(message);
    }

    //Metodo para actualizar la información de mensajes por medio del servicio
    @PutMapping("/update")//Anotación para el manejo de los metodos put
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje message) {
        return servicio.update(message);
    }

    //Metodo para eliminar un mensaje por medio del id y del servicio
    @DeleteMapping("/{id}")//Anotación para el manejo de los metodos delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return servicio.deleteMessage(messageId);
    }
}
