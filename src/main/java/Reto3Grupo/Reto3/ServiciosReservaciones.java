/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Grupo.Reto3;
//Clase Servicios Reservaciones donde se instancian atributos y metodos set and get del crud
//Librerias necesarias para la relaciones, persistencias, inserciones, etc.

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo Andres Silva A.
 */
@Service//Anotación de los componentes del servicio del framework
//Clase servicios reservaciones
public class ServiciosReservaciones {

    @Autowired//Anotación para la inyección de dependencias
    private RepositorioReservaciones metodosCrud;//Declaración de la variable proveniente del repositorio para su uso

    //Metodo get para la obtención de la lista de reservaciones con la ayuda del repositorio
    public List<Reservaciones> getAll() {
        return metodosCrud.getAll();
    }

    //Metodo get para la obtención de la lista de reservaciones con la ayuda del repositorio por medio del id 
    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    //Metodo save para grabar los datos que se ingresen para la reservación
    public Reservaciones save(Reservaciones reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservaciones> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    //Metodo update para actualizar los datos que se ingresen para la reservación
    public Reservaciones update(Reservaciones reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservaciones> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    //Metodo delete para eliminar los datos que se ingresen para la reservación    
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //Metodo para listar la cantidad de reservas completadas y canceladas
    public StatusReservas reporteStatusServicio (){
        List<Reservaciones>completed= metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservaciones>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size());
    }
    //Metodo para generar el listado de reportes por fecha de inicio y fin
    public List<Reservaciones> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }
    //Metodo para listar la cantidad de clientes
    public List<ContadorClientes> reporteClientesServicio(){
        return metodosCrud.getClientesRepositorio();
    }
}
