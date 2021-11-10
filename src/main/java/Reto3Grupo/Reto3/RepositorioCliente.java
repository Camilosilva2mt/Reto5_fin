/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Respositorio Cliente donde se implmenta lo concreot de la persistencia con el framework
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
//Clase repositorio cliente
public class RepositorioCliente {

    @Autowired//Anotación para la inyección de dependencias
    private InterfaceCliente crud1;//Declaración de la variable proveniente de la interface para su uso

    //Metodo get para la obtención de la lista de clientes con la ayuda de la interface
    public List<Cliente> getAll() {
        return (List<Cliente>) crud1.findAll();
    }

    //Metodo get para la obtención del cliente por medio del id con la ayuda de la interface
    public Optional<Cliente> getCliente(int id) {
        return crud1.findById(id);
    }

    //Metodo grabar cliente con la ayuda de la interface
    public Cliente save(Cliente cliente) {
        return crud1.save(cliente);
    }

    //Metodo eliminar cliente con la ayuda de la interface
    public void delete(Cliente cliente) {
        crud1.delete(cliente);
    }
}
