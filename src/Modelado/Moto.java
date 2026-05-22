package Modelado;

public class Moto {
    private int id;
    private String marca;
    private String modelo;
    private int cilindraje;
    private int precio;
    private String tipo;

    public Moto(int id, String marca, String modelo, int cilindraje, int precio, String tipo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.precio = precio;
        this.tipo = tipo;
    }

    public Moto(String marca, String modelo, int cilindraje, int precio, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cilindraje=" + cilindraje +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
