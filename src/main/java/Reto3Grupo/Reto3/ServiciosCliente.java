/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Servicios Cliente donde se instancian atributos y metodos set and get del crud
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
//Clase servicios cliente
public class ServiciosCliente {

    @Autowired//Anotación para la inyección de dependencias
    private RepositorioCliente metodosCrud;//Declaración de la variable proveniente del repositorio para su uso

    //Metodo get para la obtención de la lista de clientes con la ayuda del repositorio
    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }

    //Metodo get para la obtención de la lista de clientes con la ayuda del repositorio por medio del id 
    public Optional<Cliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    //Metodo save para grabar los datos que se ingresen para el cliente
    public Cliente save(Cliente client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Cliente> c = metodosCrud.getCliente(client.getIdClient());
            if (c.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }

    //Metodo update para actualizar los datos que se ingresen para el cliente
    public Cliente update(Cliente client) {
        if (client.getIdClient() != null) {
            Optional<Cliente> e = metodosCrud.getCliente(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getEmail() != null) {
                    e.get().setEmail(client.getEmail());
                }
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    //Metodo delete para eliminar los datos que se ingresen para el cliente
    public boolean deleteCliente(int clienteId) {
        Boolean aBoolean = getClient(clienteId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
