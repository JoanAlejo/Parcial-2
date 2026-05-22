package Modelado;

public class Casco {
    private int id;
    private String marca;
    private String modelo;
    private String talla;
    private String certificacion;
    private int precio;

    public Casco(int id, String marca, String modelo, String talla, String certificacion, int precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.certificacion = certificacion;
        this.precio = precio;
    }

    public Casco(String marca, String modelo, String talla, String certificacion, int precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.certificacion = certificacion;
        this.precio = precio;
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

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Casco{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", talla='" + talla + '\'' +
                ", certificacion='" + certificacion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
