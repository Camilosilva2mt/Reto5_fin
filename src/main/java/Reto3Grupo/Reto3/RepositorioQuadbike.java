/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Respositorio cuatrimoto donde se implmenta lo concreot de la persistencia con el framework
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
//Clase repositorio cuatrimoto
public class RepositorioQuadbike {

    @Autowired//Anotación para la inyección de dependencias
    private InterfaceQuadbike crud;//Declaración de la variable proveniente de la interface para su uso

    //Metodo get para la obtención de la lista de cuatrimotos con la ayuda de la interface
    public List<Quadbike> getAll() {
        return (List<Quadbike>) crud.findAll();
    }

    //Metodo get para la obtención de la cuatrimoto por medio del id con la ayuda de la interface
    public Optional<Quadbike> getQuadbike(int id) {
        return crud.findById(id);
    }

    //Metodo grabar cuatrimoto con la ayuda de la interface
    public Quadbike save(Quadbike quadbike) {
        return crud.save(quadbike);
    }

    //Metodo eliminar cuatrimoto con la ayuda de la interface
    public void delete(Quadbike quadbike) {
        crud.delete(quadbike);
    }
}
