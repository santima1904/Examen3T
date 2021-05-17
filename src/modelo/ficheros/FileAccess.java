package modelo.ficheros;

import modelo.clasesBasicas.Pelicula;
import modelo.clasesBasicas.PeliculaPago;

import java.io.*;
import java.util.*;

public class FileAccess {

    //Constantes conn nombres de los ficheros a crear
    public static final String NOMBRE = "Catalogo.dat";
    public static final String NOMBRE_MOVIMIENTO = "CatalogoMovimiento.dat";

    public static final double TASA_ALTA = 500;// he puesto un valor muy alto para que siempre sea mayor

    //Instancio los files
    private static File fichero;
    private static File movimiento;

    /**
     * Cabecera: public static List<Pelicula> leerFichero()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: lista de objetos pelicula
     * Postcondiciones: Devuelve una lista con los objetos del fichero
     */
    public static List<Pelicula> leerFichero(){
        ObjectInputStream ois = null; //Instancio el ObjectInputStream y lo pongo a nulo
        List<Pelicula> contenido = new ArrayList<>(); //creo una lista para insertar las peliculas del fichero

        try {
            ois = new ObjectInputStream(new FileInputStream(NOMBRE));//creo el ObjectInputStream y el fileinputStream con el nombre del archivo, para poder leer el contenido del fichero

            //Instancio un objeto a nulo
            Object aux = null;
            // Se lee el primer objeto
            aux = ois.readObject();

            // Mientras haya objetos
            while (aux != null) {
                try{

                    contenido.add((Pelicula) aux);  // guardo la pelicula previamente leida en una lista

                    aux = ois.readObject();//leo el siguiente

                }catch (EOFException e){
                    aux = null;//si salta la excepcion, pongo el objeto a nulo para salir del bucle
                }

            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally{
            try {
                if (ois != null) {
                    ois.close();//cierro el objectInputStream
                }
            } catch (IOException e) {//si salta la excepcion  IOException
                e.printStackTrace();//muestro la excepcion
            }
        }
        return contenido;//devuelvo la lista de peliculas
    }


    /**
     * Cabecera: public static void anhadirObjeto()
     * Precondiciones: fichero creado
     * Entradas: Pelicula  p
     * Salida: niunguna
     * Postcondiciones: Inserta el objeto p en el fichero
     */
    public static void anhadirObjeto(Pelicula p) {
        fichero = new File(NOMBRE);//guardo el espacio indicado para el archivo

        ObjectOutputStream oos = null;//Instancio el ObjectOutputStream y lo pongo a nulo

        try {
            if (fichero.exists()){//si el fichero existe
                oos = new MyObjectOutputStream(new FileOutputStream(NOMBRE, true));//uso mi propio ObjectOutputStream para no sobreescribir los productos, simplemente añadirlos
            }else{
                fichero.createNewFile();//si no esta creado, lo creo
                oos = new ObjectOutputStream(new FileOutputStream(NOMBRE, true));//uso el ObjectOutputStream de java para escribir en un fichero nuevo
            }

            oos.writeObject(p);//escribo el objeto en  el fichero

        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }
        finally {
            if (oos != null) {
                try {
                    oos.close();// cierro el ObjectOutputStream
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Cabecera: public static void anhadirObjetoFicheroMovimiento()
     * Precondiciones: fichero creado
     * Entradas: Pelicula  p
     * Salida: niunguna
     * Postcondiciones: Inserta el objeto p en el fichero de movimiento
     */
    public static void anhadirObjetoFicheroMovimiento(Pelicula p) {
        movimiento = new File(NOMBRE_MOVIMIENTO);

        ObjectOutputStream oos = null;//Instancio el ObjectOutputStream y lo pongo a nulo

        try {
            if (movimiento.exists()){//si el fichero existe
                oos = new MyObjectOutputStream(new FileOutputStream(NOMBRE_MOVIMIENTO, true));//uso mi propio ObjectOutputStream para no sobreescribir los productos, simplemente añadirlos
            }else{
                movimiento.createNewFile();//si no esta creado, lo creo
                oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_MOVIMIENTO, true));//uso el ObjectOutputStream de java para escribir en un fichero nuevo
            }

            oos.writeObject(p);//escribo el objeto en  el fichero

        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }
        finally {
            if (oos != null) {
                try {
                    oos.close();// cierro el ObjectOutputStream
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Cabecera: public static void borrarObjetoFicheroMovimiento()
     * Precondiciones: fichero creado
     * Entradas:  String nombre
     * Salida: niunguna
     * Postcondiciones: Anhade el objeto que se desea borrar al fichero de movimiento con el nombre a null, para indicar que debe ser borrado
     */

    public static void borrarObjetoFicheroMovimiento(String nombre){
        System.out.println("En resguardo");
    }


    /**
     * Cabecera: public static boolean leerFicheroNombre()
     * Precondiciones: fichero creado
     * Entradas: String nombre
     * Salida: booleano repetido
     * Postcondiciones: Devuelve una lista con los objetos del fichero
     */
    public static boolean leerFicheroNombre(String nombre){
        ObjectInputStream ois = null; //Instancio el ObjectInputStream y lo pongo a nulo
        boolean repetido = false;//variable para indicar si el nombre ya pertenece a un objeto en el fichero

        try {
            ois = new ObjectInputStream(new FileInputStream(NOMBRE));//creo el ObjectInputStream y el fileinputStream con el nombre del archivo, para poder leer el contenido del fichero

            //Instancio un objeto a nulo
            Object aux = null;
            // Se lee el primer objeto
            aux = ois.readObject();

            // Mientras haya objetos
            while (aux != null || repetido) {
                try{

                    //ya indico arriba que el objeto no puede ser nulo, pero me lanzaba una excepcion si no lo ponia en el if tambien
                    if (aux != null && ((Pelicula) aux).getNombre().equals(nombre)) {//si el objeto no es nulo y si el nombre del objeto que se lee, es igual al dado, repetido se pone a true y sale del bucle
                        repetido = true;//pongo true como true para indicar que esta repetido
                    }
                    aux = ois.readObject();//leo el siguiente


                }catch (EOFException e){

                    aux = null;//si salta la excepcion, pongo el objeto a nulo para salir del bucle
                }

            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally{
            try {
                if (ois != null) {
                    ois.close();//cierro el objectInputStream
                }
            } catch (IOException e) {//si salta la excepcion  IOException
                e.printStackTrace();//muestro la excepcion
            }
        }
        return repetido;//devuelvo una variable que indica si el atributo esta repetido en algun objeto del fichero
    }

    /**
     * Cabecera: public static double sumarCostesPeliculas()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: double suma
     * Postcondiciones: Devuelve un double con el sumatorio de los costes
     */
    public static double sumarCostesPeliculas(){
        ObjectInputStream ois = null; //Instancio el ObjectInputStream y lo pongo a nulo
        double suma = 0;//variable para llevar la suma de costes

        try {
            ois = new ObjectInputStream(new FileInputStream(NOMBRE));//creo el ObjectInputStream y el fileinputStream con el nombre del archivo, para poder leer el contenido del fichero

            //Instancio un objeto a nulo
            Object aux = null;
            // Se lee el primer objeto
            aux = ois.readObject();

            // Mientras haya objetos
            while (aux != null) {//mientras no haya objetos nulos
                try{

                    if (aux instanceof PeliculaPago){//si el objeto es una instancia de PeliculaPago, ya que necesitamos el coste
                        suma += ((PeliculaPago)aux).getCoste();//anhado el valor del coste de aux a la variable suma
                    }
                    aux = ois.readObject();//leo el siguiente


                }catch (EOFException e){

                    aux = null;//si salta la excepcion, pongo el objeto a nulo para salir del bucle
                }

            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally{
            try {
                if (ois != null) {
                    ois.close();//cierro el objectInputStream
                }
            } catch (IOException e) {//si salta la excepcion  IOException
                e.printStackTrace();//muestro la excepcion
            }
        }
        return suma;//devuelvo un double que indica la suma de los costes de las pelis de pago
    }


    /**
     * Cabecera: public static Pelicula peliculasMenosTasa()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: Pelicula pelicula
     * Postcondiciones: Devuelve el objeto pelicula del fichero con menor tasa de impacto
     */
    public static Pelicula peliculasMenosTasa(){
        ObjectInputStream ois = null; //Instancio el ObjectInputStream y lo pongo a nulo
        Pelicula pelicula = null;//instancio un objeto pelicula a null
        double tasaMenor = TASA_ALTA;//variable para tener una referencia de la tasa menor

        try {
            ois = new ObjectInputStream(new FileInputStream(NOMBRE));//creo el ObjectInputStream y el fileinputStream con el nombre del archivo, para poder leer el contenido del fichero

            //Instancio un objeto a nulo
            Object aux = null;
            // Se lee el primer objeto
            aux = ois.readObject();

            // Mientras haya objetos
            while (aux != null) {
                try{

                    if (((Pelicula)aux).getTasaImpacto() < tasaMenor){//si la tasa del objeto es menor que la variable tasa
                        pelicula = (Pelicula)aux;//le asigno el objeto aux a pelicula
                        tasaMenor = ((Pelicula) aux).getTasaImpacto();//le asigno el valor de la tasa de aux a la variable tasa para que sea la menor
                    }
                    aux = ois.readObject();//leo el siguiente


                }catch (EOFException e){

                    aux = null;//si salta la excepcion, pongo el objeto a nulo para salir del bucle
                }

            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally{
            try {
                if (ois != null) {
                    ois.close();//cierro el objectInputStream
                }
            } catch (IOException e) {//si salta la excepcion  IOException
                e.printStackTrace();//muestro la excepcion
            }
        }
        return pelicula ;//devuelvo el objeto pelicula con la menor tasa
    }

    /**
     * Cabecera: public static List<Pelicula> peliculasAnhoDado()
     * Precondiciones: fichero creado
     * Entradas: int anho
     * Salida: lista de objetos pelicula
     * Postcondiciones: Devuelve una lista con los objetos peliculas cuyo anho de estreno es igual al dado
     */
    public static List<Pelicula> peliculasAnhoDado(int anho){
        List<Pelicula> pelis = new ArrayList<>();
        System.out.println("En resguardo");
        return  pelis;//devuelvo la lista de peliculas
    }


    /**
     * Cabecera: private void borrarFicheros()
     * Precondiciones:ficheros creados
     * Entradas: ninguna
     * Salida: niunguna
     * Postcondiciones: borra los ficheros.
     */
    //Este metodo lo uso para borrar los ficheros antes de probar en el main de prueba en el primer ejercicio
    public static void borrarFicheros(){
        fichero = new File(NOMBRE);
        movimiento = new File(NOMBRE_MOVIMIENTO);

        fichero.delete();//borro el fichero principal
        movimiento.delete();//borro el fichero de movimiento

    }



}