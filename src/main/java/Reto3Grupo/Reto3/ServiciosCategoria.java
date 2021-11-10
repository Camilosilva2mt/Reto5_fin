/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Servicios Categoria donde se instancian atributos y metodos set and get del crud
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
public class ServiciosCategoria {

    @Autowired//Anotación para la inyección de dependencias
    private RepositorioCategoria metodosCrud;//Declaración de la variable proveniente del repositorio para su uso

    //Metodo get para la obtención de la lista de categorias con la ayuda del repositorio
    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    //Metodo get para la obtención de la lista de categorias con la ayuda del repositorio por medio del id 
    public Optional<Categoria> getCategoria(int categoriaId) {
        return metodosCrud.getCategoria(categoriaId);
    }

    //Metodo save para grabar los datos que se ingresen para la categoria
    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> sc = metodosCrud.getCategoria(categoria.getId());
            if (sc.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    //Metodo update para actualizar los datos que se ingresen para la categoria
    public Categoria update(Categoria categoria) {
        if (categoria.getId() != null) {
            Optional<Categoria> g = metodosCrud.getCategoria(categoria.getId());
            if (!g.isEmpty()) {
                if (categoria.getDescription() != null) {
                    g.get().setDescription(categoria.getDescription());
                }
                if (categoria.getName() != null) {
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }

    //Metodo delete para eliminar los datos que se ingresen para la categoria
    public boolean deleteCategoria(int categoriaId) {
        Boolean d = getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
