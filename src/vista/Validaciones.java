/**
 * Clase encargada de recoger datos directamente del usuario y validarlos
 */
package vista;

import modelo.ficheros.FileAccess;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import static java.time.temporal.ChronoField.*;

public class Validaciones {


    //Creo dos teclados para que no haya problemas al intercalar strings con doubles
    public static Scanner teclado = new Scanner(System.in);
    public static Scanner tecladoString = new Scanner(System.in);


    //Metodos para validar

    /**
     * Cabecera: public static LocalDate pedirFecha()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: LocalDate con la fecha
     * Postcondiciones: Valida la fecha introducida por teclado. Si es válida devuelve true, si no lo es, false
     */

    public static LocalDate pedirFecha() {

        LocalDate fecha = null;//variable para gaurdar la fecah introducida por el usuario
        boolean fechaValida = false;//booleano para ver si la fecvha es valida

        do {//hago un do while para que al menos se haga una vez
            try {
                System.out.println("Inserte la fecha de lanzamiento: ");
                fecha = LocalDate.of(pedirAnho(), pedirMes(), pedirDia());//creop la fecha usando los metodos creados posteriormente para pedir los diferentes datos
                fechaValida = true;//si se ejecuta sin errores, el booleano se pone a true para salir del bucle
            } catch (DateTimeException d) {
                System.out.println("Fecha no valida");//mensaje para informar al usuario del error

            }
        }while (!fechaValida) ;//condicion del bucle

        return fecha;
    }


    /**
     * Cabecera: public static int pedirDia()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int con el dia
     * Postcondiciones: Pide un int al usuario
     */

    public static int pedirDia(){
        int dia = 0;//variable para guardar la fecha introducida por el usuario
        boolean valido = false;//booleano para ver si la fecvha es valida

        do{//hago un do while para que al menos se haga una vez
            System.out.println("Introduzaca un dia:");
            dia = teclado.nextInt();

            try{
                DAY_OF_MONTH.checkValidValue(dia);//metodo para comprobar si el dia es valido. Si es valido, devuelve el dia, si no lo es, lanza una excepcion
                valido = true;//si se ejecuta sin errores, el booleano se pone a true para salir del bucle

            }catch(DateTimeException e){
                System.out.println("Fecha no valida");//mensaje para informar al usuario del error

            }

        }while(!valido);//condicion del bucle

        return dia;
    }



    /**
     * Cabecera: public static int pedirMes()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int con el mes
     * Postcondiciones: Pide un int al usuario
     */

    public static int pedirMes(){

        int mes = 0;//variable para guardar la fecha introducida por el usuario
        boolean valido = false;//booleano para ver si la fecvha es valida

        do{
            System.out.println("Introduzaca un mes:");
            mes = teclado.nextInt();

            try{
                MONTH_OF_YEAR.checkValidValue(mes);//metodo para comprobar si el mes es valido. Si es valido, devuelve el mes, si no lo es, lanza una excepcion
                valido =  true;//si se ejecuta sin errores, el booleano se pone a true para salir del bucle

            }catch(DateTimeException e){
                System.out.println("Fecha no valida");//mensaje para informar al usuario del error
            }

        }while(!valido);//condicion del bucle

        return mes;
    }

    /**
     * Cabecera: public static int pedirAnho()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int con el anho
     * Postcondiciones: Pide un int al usuario
     */

    public static int pedirAnho(){
        int anho = 0;//variable para guardar la fecha introducida por el usuario
        boolean valido = false;//booleano para ver si la fecvha es valida

        do{
            System.out.println("Introduzaca un anho:");
            anho = teclado.nextInt();

            try{
                YEAR_OF_ERA.checkValidValue(anho);//metodo para comprobar si el anho es valido. Si es valido, devuelve el anho, si no lo es, lanza una excepcion
                valido =  true;//si se ejecuta sin errores, el booleano se pone a true para salir del bucle

            }catch(DateTimeException e){
                System.out.println("Fecha no valida");//mensaje para informar al usuario del error
            }

        }while(!valido);//condicion del bucle

        return anho;
    }

    /**
     * Cabecera: public static String pedirNombre()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: string nombre
     * Postcondiciones: Pide una cadena con el nombre al usuario
     */

    public static String pedirNombre(){
        String nombre = null;//variable para recoger los datos insertados por teclado y devolverlo
        boolean repetido = true;

        while(nombre == null || repetido){//mientras no sea nulo o este vacio o este repetido
            System.out.println("Inserte un nombre: ");
            nombre = tecladoString.nextLine();
            repetido = FileAccess.leerFicheroNombre(nombre);

        }

        return nombre;//devuelvo la variable
    }

    /**
     * Cabecera: public static double pedirDouble()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: double nota
     * Postcondiciones: Pide un double con la nota al usuario
     */

    public static double pedirNota(){
        double nota = 20;

        while(nota < 0 || nota > 10) {
            System.out.println("Inserte la nota: ");
            nota = teclado.nextDouble();
        }

        return nota;
    }

    /**
     * Cabecera: public static double pedirPresupuesto()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: double presupuesto
     * Postcondiciones: Pide un double con el presupuesto al usuario
     */

    public static double pedirPresupuesto(){
        double presupuesto = 0;

        while(presupuesto <= 0) {
            System.out.println("Inserte el presupuesto: ");
            presupuesto = teclado.nextDouble();
        }

        return presupuesto;
    }

    /**
     * Cabecera: public static double pedirCoste()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: double coste
     * Postcondiciones: Pide un double con el coste al usuario
     */

    public static double pedirCoste(){
        double coste = 0;

        while(coste <= 0) {
            System.out.println("Inserte el coste: ");
            coste = teclado.nextDouble();
        }

        return coste;
    }

    /**
     * Cabecera: public static int pedirOpcion2Posibilidades()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int
     * Postcondiciones: Pide un int con la opcion al usuario
     */
    //este metodo pide la opcion entre dos posibles
    public static int pedirOpcion2Posibilidades(){

        int opcion = 0;//variable para recoger la opcion por teclado

        while(opcion != 1 && opcion != 2){//repetir mientras el usuario no ponga un 1 o un 2
            opcion = teclado.nextInt();
        }


        return opcion;//devuelvo el int con la opcion
    }

    /**
     * Cabecera: public static int pedirOpcion3Posibilidades()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int
     * Postcondiciones: Pide un int con la opcion al usuario
     */
    //este metodo pide la opcion entre tres posibles
    public static int pedirOpcion3Posibilidades(){

        int opcion = 0;//variable para recoger la opcion por teclado

        while(opcion != 1 && opcion != 2 && opcion != 3){//repetir mientras el usuario no ponga un 1 o un 2
            opcion = teclado.nextInt();
        }


        return opcion;//devuelvo el int con la opcion
    }

    /**
     * Cabecera: public static boolean salir()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: boolean
     * Postcondiciones: Pide un int al usuario y si es uno manda un booleano true
     */

    public static boolean salir(){

        int opcion = 0;//variable para recoger la opcion por teclado
        boolean salir = false;//booleano para devolver, lo inicio a false

        while(opcion != 1 && opcion != 2){//repetir mientras el usuario no ponga un 1 o un 2
            opcion = teclado.nextInt();
        }
        if (opcion == 1){//si la respuesta es 1, pongo salir a true
            salir = true;
        }

        return salir;//devuelvo el booleano salir
    }
}
