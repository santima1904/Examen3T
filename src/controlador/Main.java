package controlador;

import modelo.ficheros.FileAccess;
import vista.Mensaje;
import vista.Validaciones;



public class Main {
    public static void main(String[] args) {

        do {

            Mensaje.mostrarMenu();//Menu principal del programa
            switch (Validaciones.pedirOpcion3Posibilidades()){//switch dependiendo de la opcion del usuario
                case 1:
                    FileAccess.peliculasAnhoDado(Validaciones.pedirAnho());//metodo en resguardo
                    break;

                case 2:
                    Mensaje.mostrarMenu2();//menu de la segunda opcion
                    switch (Validaciones.pedirOpcion2Posibilidades()){//switch dependiendo de la opcion del usuario

                        case 1:
                            Mensaje.menuSuma(FileAccess.sumarCostesPeliculas());//opcion de mostrar sumatorio de costes
                            break;

                        case 2:
                            Mensaje.menuTasa(FileAccess.peliculasMenosTasa());//opcion de mostrar la pelicula con menor tasa
                    }
                    break;

                case 3:
                    Mensaje.mostrarMenu3();
                    switch (Validaciones.pedirOpcion2Posibilidades()){//switch dependiendo de la opcion del usuario

                        case 1:
                            Mensaje.mostrarMenuTipoPeli();//menu para preguntar por el tipo de pelicula
                            FileAccess.anhadirObjetoFicheroMovimiento(Utilidades.crearObjeto(Validaciones.pedirOpcion2Posibilidades(), Validaciones.pedirNombre(),Validaciones.pedirFecha(), Validaciones.pedirNota(), Validaciones.pedirPresupuesto(), Validaciones.pedirCoste()));
                            //metodo que anhade una pelicula al archivo, para ello llama al metodo crearObjeto de Utilidades para crear el objeto deseado.
                            //A este metodo se le pasan por parametros los valores de los atributos pedidos por teclado al usuario
                            break;

                        case 2:
                            FileAccess.borrarObjetoFicheroMovimiento(Validaciones.pedirNombre());//opcion en resguardo


                    }
                    break;
            }


            Mensaje.menuSalir();//menu para dar opcion de salir o seguir haciendo operaciones

        }while(Validaciones.salir());//si el usuario indidca salir(salir = true), el programa se cierra
    }

}
