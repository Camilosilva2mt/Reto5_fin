/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Respositorio Categoria donde se implmenta lo concreot de la persistencia con el framework
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
public class RepositorioCategoria {

    @Autowired//Anotación para la inyección de dependencias
    private InterfaceCategoria crud;//Declaración de la variable proveniente de la interface para su uso
    //Metodo get para la obtención de la lista de categorias con la ayuda de la interface    

    public List<Categoria> getAll() {
        return (List<Categoria>) crud.findAll();
    }

    //Metodo get para la obtención del categoria por medio del id con la ayuda de la interface
    public Optional<Categoria> getCategoria(int id) {
        return crud.findById(id);
    }

    //Metodo grabar categoria con la ayuda de la interface
    public Categoria save(Categoria categoria) {
        return crud.save(categoria);
    }

    //Metodo eliminar categoria con la ayuda de la interface
    public void delete(Categoria categoria) {
        crud.delete(categoria);
    }
}
