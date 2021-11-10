/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase controladora de la clase Reservaciones donde se instancian los rest para controlar las acciones de la api (POST, GET, PUT Y DELETE)
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
@RequestMapping("/api/Reservation")//Anotación para relacionar un metodo con una petición http
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

//Declaración de la clase
public class ControladorReservaciones {

    @Autowired//Anotación para la inyección de dependencias
    private ServiciosReservaciones servicio;//Declaración de la variable proveniente del servicio para su uso

    //Metodo para la obtención de la lista de reservaciones por medio del servicio
    @GetMapping("/all")//Anotación para el manejo de los metodos get
    public List<Reservaciones> getReservations() {
        return servicio.getAll();
    }

    //Metodo para la obtención de la lista de reservaciones por el id medio del servicio
    @GetMapping("/{id}")//Anotación para el manejo de los metodos get
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }

    //Metodo para grabar la información de reservaciones por medio del servicio
    @PostMapping("/save")//Anotación para el manejo de los metodos post
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return servicio.save(reservation);
    }

    //Metodo para actualizar la información de las reservaciones por medio del servicio
    @PutMapping("/update")//Anotación para el manejo de los metodos put
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return servicio.update(reservation);
    }

    //Metodo para eliminar una reservacion por medio del id y del servicio
    @DeleteMapping("/{id}")//Anotación para el manejo de los metodos delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }
    
    //Metodo para la obtención de la lista del estado de las reservaciones
    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return servicio.reporteStatusServicio();
    }
    
    //Metodo para la obtención de la lista de reservaciones por fecha de inicio y fecha fin
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservaciones> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
        return servicio.reporteTiempoServicio(dateOne, dateTwo);
    }
    
    //Metodo para la obtención de la lista de reportes por cliente
    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return servicio.reporteClientesServicio();
    }
}
