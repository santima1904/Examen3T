package modelo.clasesBasicas;

import java.io.Serializable;
import java.time.LocalDate;

public class Pelicula implements Serializable, Comparable<Pelicula> {

    //Atributos
    private String nombre;
    private LocalDate fechaLanzamiento;
    private double notaCritica;
    private double presupuesto;

    //Atributos calculados
    protected double tasaImpacto;//el atributo es protected para poder usarlo con las clases hijas

    //Constantes
    public final double CONSTANTE_TASA = 2;

    //Constructor por defecto
    public Pelicula() {
        this.nombre = null;
        this.fechaLanzamiento = null;
        this.notaCritica = 5;
        this.presupuesto = 0;
        this.tasaImpacto = calcularTasa();
    }

    //Constructor por parametros

    public Pelicula(String nombre, LocalDate fechaLanzamiento, double notaCritica, double presupuesto) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.notaCritica = notaCritica;
        this.presupuesto = presupuesto;
        this.tasaImpacto = calcularTasa();
    }

    //Getters and setters

    public String getNombre() {
        return nombre;
    }

    //En el enunciado no pone que sea modificable, pero necesito poder cambiar el nombre para otras funcionalidades
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public double getNotaCritica() {
        return notaCritica;
    }

    public void setNotaCritica(double notaCritica) {
        this.notaCritica = notaCritica;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public double getTasaImpacto() {
        return tasaImpacto;
    }

    //Metodos de la clase Object

    //toString
    @Override
    public String toString() {
        return
                nombre+","+
                fechaLanzamiento+","
                +notaCritica+","
                + presupuesto +","
                + tasaImpacto
                ;
    }
    //TODO me falta hacer la ordenacion al reves, de la z a la a
    //compareTo
    /*
    Criterios de igualdad:
     0 si son iguales
     1 si el objeto dado es mayor
    -1 si es menor
     */
    public int compareTo(Pelicula pelicula) {

        return this.nombre.compareTo(pelicula.getNombre());
    }

    //equals

    /**
     * Descripcion: Devuelve true sin son iguales y false si no
     *
     * @param pelicula
     * @return boolean igual
     */
    public boolean equals(Pelicula pelicula) {
        boolean igual = false;

        if (this == pelicula){
            igual = true;
        }
        if (!(pelicula instanceof Pelicula)){
            if (this.nombre == pelicula.getNombre()){
                igual = true;
            }
        }
        return igual;
    }

    //Metodos anhadidos

    /**
     * Descripcion: Metodo para calcular el valor de la tasa de impacto de cada pelicula
     *
     * @return double con el valor de la tasa de impacto
     */
    public double calcularTasa(){//hago el metodo protected para poder usarlo con sus clases hijas

        return (getNotaCritica() * CONSTANTE_TASA + calcularValorEspecifico()) * CONSTANTE_TASA;
    }

    /**
     * Descripcion: Metodo para calcular el valor del valor especifico de cada pelicula(se diferencia entre peliculas y peliculas de pago), necesario para calcular la tasa
     *
     * @return double con valor especifico
     */
    public double calcularValorEspecifico(){

        return presupuesto * CONSTANTE_TASA;
    }

}
