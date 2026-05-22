package Modelado;

public class Moto {
    private int id;
    private String marca;
    private String modelo;
    private int cilindraje;
    private double precio;
    private String tipo;

    public Moto(int id, String marca, String modelo, int cilindraje, double precio, String tipo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.precio = precio;
        this.tipo = tipo;
    }
}
