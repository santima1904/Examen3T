package tests;

import controlador.Utilidades;
import jdk.swing.interop.SwingInterOpUtils;
import modelo.clasesBasicas.Pelicula;
import modelo.clasesBasicas.PeliculaPago;
import modelo.ficheros.FileAccess;
import vista.Mensaje;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
            LocalDate fecha = LocalDate.of(2020, 2, 2);
            Pelicula p1 = new Pelicula("a",fecha, 1, 100);
            Pelicula p3 = new Pelicula("c",fecha, 6, 100);
            Pelicula p4 = new Pelicula("d",fecha, 4, 100);
            Pelicula p2 = new PeliculaPago("b",fecha, 1, 100, 10);

            //borrar ficheros
            FileAccess.borrarFicheros();
            //Insertar en fichero
            FileAccess.anhadirObjeto(p1);
            FileAccess.anhadirObjeto(p2);
            FileAccess.anhadirObjeto(p3);
            FileAccess.anhadirObjeto(p4);
            System.out.println("-------Mostrar fichero-------");
            Mensaje.mostrarLista(FileAccess.leerFichero());
            System.out.println("-------Mostrar fichero ordenado-------");
            Mensaje.mostrarLista(Utilidades.ordenar(FileAccess.leerFichero()));
            System.out.println();
            System.out.println("-------Mostrar fichero ordenado-------");
            FileAccess.anhadirObjetoFicheroMovimiento(p4);
            FileAccess.borrarObjetoFicheroMovimiento("a");
            Mensaje.mostrarLista(FileAccess.leerFichero());


            System.out.println("Prueba de metodos");
            System.out.println("Probar tasa impacto");
            //pruebo con una pelicula normal
            //deberia dar la tasa 404 por la formula aplicada
            System.out.println(p1);

            System.out.println("Pruebo con una pelicula de pago");
            //deberia dar la tasa 62 por la formula aplicada
            System.out.println(p2);

            System.out.println("Pruebo el equals");
            //Al no tener el mismo nombre, no son iguales, por lo tanto devuelve false
            System.out.println(p1.equals(p3));
            //estos si tienen el mismo nombre, son el mismo objeto
            System.out.println(p1.equals(p1));

            System.out.println("Pruebo el compareto");
            //El compareto deberia volver un negativo al ser menor
            System.out.println(p1.compareTo(p2));
    }
}
