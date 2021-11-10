/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Servicios Cuatrimotos donde se instancian atributos y metodos set and get del crud
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
//Clase servicios cuatrimotos
public class ServiciosQuadbike {

    @Autowired//Anotación para la inyección de dependencias
    private RepositorioQuadbike metodosCrud;//Declaración de la variable proveniente del repositorio para su uso

    //Metodo get para la obtención de la lista de cuatrimotos con la ayuda del repositorio
    public List<Quadbike> getAll() {
        return metodosCrud.getAll();
    }

    //Metodo get para la obtención de la lista de cuatrimotos con la ayuda del repositorio por medio del id     
    public Optional<Quadbike> getQuadbike(int quadbikeId) {
        return metodosCrud.getQuadbike(quadbikeId);
    }

    //Metodo save para grabar los datos que se ingresen para la cuatrimoto    
    public Quadbike save(Quadbike quadbike) {
        if (quadbike.getId() == null) {
            return metodosCrud.save(quadbike);
        } else {
            Optional<Quadbike> e = metodosCrud.getQuadbike(quadbike.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(quadbike);
            } else {
                return quadbike;
            }
        }
    }

    //Metodo update para actualizar los datos que se ingresen para la cuatrimoto    
    public Quadbike update(Quadbike quadbike) {
        if (quadbike.getId() != null) {
            Optional<Quadbike> e = metodosCrud.getQuadbike(quadbike.getId());
            if (!e.isEmpty()) {
                if (quadbike.getName() != null) {
                    e.get().setName(quadbike.getName());
                }
                if (quadbike.getBrand() != null) {
                    e.get().setBrand(quadbike.getBrand());
                }
                if (quadbike.getYear() != null) {
                    e.get().setYear(quadbike.getYear());
                }
                if (quadbike.getDescription() != null) {
                    e.get().setDescription(quadbike.getDescription());
                }
                if (quadbike.getCategory() != null) {
                    e.get().setCategory(quadbike.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return quadbike;
            }
        } else {
            return quadbike;
        }
    }

    //Metodo delete para eliminar los datos que se ingresen para la cuatrimoto    
    public boolean deleteQuadbike(int quadbikeId) {
        Boolean aBoolean = getQuadbike(quadbikeId).map(quadbike -> {
            metodosCrud.delete(quadbike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
