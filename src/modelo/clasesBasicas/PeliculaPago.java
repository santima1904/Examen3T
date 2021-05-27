package modelo.clasesBasicas;

import java.time.LocalDate;

public class PeliculaPago extends Pelicula{

    //Atributos
    private double coste;

    //Constantes
    public final double CONSTANTE_VALOR_ESPECIFICO = 3;

    //Constructor por defecto

    public PeliculaPago() {
        this.coste = 0;
    }

    //Constructor por parametros

    public PeliculaPago(String nombre, LocalDate fechaLanzamiento, double notaCritica, double presupuesto, double coste) {
        super(nombre, fechaLanzamiento, notaCritica, presupuesto);
        this.coste = coste;
    }

    //Getters and setters

    public double getCoste() {
        return coste;
    }

    //Metodos de la clase Object

    @Override
    public String toString() {
        return super.toString()+","
                + coste;
    }

    //Metodos anhadidos

    /**
     * Precondiciones: constante existente
     * Entradas: Ninguna
     * Salida: calculo resultante de multiplicar el coste con la constante del valor especifico
     * Descripcion: Metodo para calcular el valor del valor especifico de cada pelicula(se diferencia entre peliculas y peliculas de pago), necesario para calcular la tasa
     *
     * @return double con valos especifico
     */
    @Override
    public double calcularValorEspecifico(){

        return coste * CONSTANTE_VALOR_ESPECIFICO;
    }
}
