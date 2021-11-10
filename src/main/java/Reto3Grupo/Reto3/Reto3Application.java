/*
Modelo para la creación de cada una de las clases e interfaces necesarias para la aplicación
1.Modelo o Entidad
2.Interface
3.Repositorio
4.Servicios
5.Controlador o Web*/

package Reto3Grupo.Reto3;
//Clase Principal
/**
 *
 * @author Camilo Andres Silva A.
 */
//Librerias necesarias para la relaciones, persistencias, inserciones, etc.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//
@SpringBootApplication//Anotación que abrevia las 3 configuraciones principales que realiza automaticamente este framework

//Clase principal serializable
public class Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);//Llamado de la clase principal para su ejecución
	}

}
