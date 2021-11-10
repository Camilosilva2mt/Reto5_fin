/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Servicios Mensaje donde se instancian atributos y metodos set and get del crud
//Librerias necesarias para la relaciones, persistencias, inserciones, etc.

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo Andres Silva A.
 */
@Service//Anotación de los componentes del servicio del framework
//Clase servicios mensaje
public class ServiciosMensaje {

    @Autowired//Anotación para la inyección de dependencias
    private RepositorioMensaje metodosCrud;//Declaración de la variable proveniente del repositorio para su uso

    //Metodo get para la obtención de la lista de mensajes con la ayuda del repositorio
    public List<Mensaje> getAll() {
        return metodosCrud.getAll();
    }

    //Metodo get para la obtención de la lista de mensajes con la ayuda del repositorio por medio del id 
    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    //Metodo save para grabar los datos que se ingresen para el mensaje
    public Mensaje save(Mensaje message) {
        if (message.getIdMessage() == null) {
            return metodosCrud.save(message);
        } else {
            Optional<Mensaje> e = metodosCrud.getMessage(message.getIdMessage());
            if (e.isEmpty()) {
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }

    //Metodo update para actualizar los datos que se ingresen para el mensaje
    public Mensaje update(Mensaje message) {
        if (message.getIdMessage() != null) {
            Optional<Mensaje> e = metodosCrud.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    //Metodo delete para eliminar los datos que se ingresen para el mensaje
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
