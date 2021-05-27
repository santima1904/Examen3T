package controlador;

import modelo.clasesBasicas.Pelicula;
import modelo.clasesBasicas.PeliculaPago;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Utilidades {

    /**
     * Cabecera: public static void ordenar()
     * Precondiciones: lista cargada y creada
     * Entradas: Lista de productos
     * Salida: lista de productos
     * Postcondiciones: Ordena la lista con los elementos del fichero
     */
    public static List<Pelicula> ordenar(List<Pelicula> contenido){

        Collections.sort(contenido);//ordeno la lista

        return contenido;
    }

    /**
     * Cabecera: public static Pelicula crearObjeto()
     * Precondiciones: entradas validadas
     * Entradas: int tipo, String nombre, LocalDate fecha, double nota, double presupuesto, double coste
     * Salida: objeto Pelicula
     * Postcondiciones: crea un objeto pelicula a partir de los valores pasados por parametros
     */
    public static Pelicula crearObjeto(int tipo, String nombre, LocalDate fecha, double nota, double presupuesto, double coste){
        Pelicula p;//instancio el objeto p

        if (tipo == 1){// si es 1, es decir, gratis
             p = new Pelicula(nombre, fecha, nota, presupuesto);//creo un objeto pelicula
        }else{// si es de pago
             p = new PeliculaPago(nombre, fecha, nota, presupuesto, coste);//creo objeto peliculaPago
        }

        return p;
    }

}
