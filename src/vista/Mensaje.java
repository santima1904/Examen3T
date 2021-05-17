package vista;

import modelo.clasesBasicas.Pelicula;

import java.util.List;

public class Mensaje {

    //Constantes con mensajes
    public static final String MENU_PRINCIPAL = "Bienvenidos a Nervionflix"+"\n"+
                                                "1. Menu impresion"+"\n"+
                                                "2. Menu calculos"+"\n"+
                                                "3. Menu gestion";

    public static final String MENU_2 =
            "1. Sumatorio del coste de las peliculas de pago"+"\n"+
            "2. Mostrar datos de la pelicula con menor tasa de impacto";

    public static final String MENU_3 =
            "1. Anhadir una pelicula"+"\n"+
            "2. Borrar una pelicula";

    public static final String SALIR = "Desea seguir: " +"\n"
            +"1. Si"+"\n"+"2.No";

    public static final String MENU_TIPO_PELI = "Que tipo de pelcula quiere: " +"\n"
            +"1. Gratis"+"\n"+"2.De pago";

    public static final String SUMA = "La suma de los costes es de: ";
    public static final String TASA = "La pelicula con menor tasa de impacto es: ";

    /**
     * Cabecera: public static void mostrarLista(Lista p)
     * Precondiciones: lista creada
     * Entrada: lista de productos
     * Salida: ninguna
     * Postcondiciones: Muestra por pantalla el contenido de la lista
     */

    public static void mostrarLista(List<Pelicula> contenido){

        for (Pelicula pelicula: contenido) {
            System.out.println(pelicula);
        }
    }

    /**
     * Cabecera: public void mostrarMenu()
     * Descripcion: muestra el menu principal por pantalla
     */

    public static void mostrarMenu(){
        System.out.println(MENU_PRINCIPAL);
    }

    /**
     * Cabecera: public void mostrarMenu2()
     * Descripcion: muestra el menu de la segunda opcion por pantalla
     */

    public static void mostrarMenu2(){
        System.out.println(MENU_2);
    }

    /**
     * Cabecera: public void mostrarMenu3()
     * Descripcion: muestra el menu de la tercera opcion por pantalla
     */

    public static void mostrarMenu3(){
        System.out.println(MENU_3);
    }

    /**
     * Cabecera: public void mostrarMenuTipoPeli()
     * Descripcion: muestra el menu de elegir el tipo de pelicula por pantalla
     */

    public static void mostrarMenuTipoPeli(){
        System.out.println(MENU_TIPO_PELI);
    }

    /**
     * Cabecera: public void mostrar menuSalir()
     * Descripcion: mostrar menu de salir por pantalla
     */

    public static void menuSalir(){
        System.out.println(SALIR);
    }

    /**
     * Cabecera: public void mostrar menuSuma()
     * Entradas: double suma
     * Descripcion: mostrar menu de opcion sumatorio por pantalla
     */

    public static void menuSuma(double suma){
        System.out.println(SUMA+suma);
    }

    /**
     * Cabecera: public void mostrar menuTasa()
     * Entradas: Pelicula pelicula
     * Descripcion: mostrar menu de opcion tasa menor por pantalla
     */

    public static void menuTasa(Pelicula pelicula){
        System.out.println(TASA+pelicula);
    }
}
