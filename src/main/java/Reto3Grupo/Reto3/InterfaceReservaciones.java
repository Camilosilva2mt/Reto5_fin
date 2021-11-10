/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3Grupo.Reto3;
//Interface Reservaciones que nos permitira el uso del repositorio de spring en nuestra aplicación

//Librerias necesarias para la relaciones, persistencias, inserciones, etc.
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Camilo Andres Silva A.
 */
//Declaración de la interface reservaciones junto con el nombre de la clase principal y el tipo de dato de la llave primaria
public interface InterfaceReservaciones extends CrudRepository<Reservaciones, Integer> {

    public List<Reservaciones> findAllByStatus (String status);
    
    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    @Query ("SELECT c.client, COUNT (c.client) from Reservaciones AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}
