public class Autos1 {
    protected String nombrepers;
    protected String nserie;
    protected String marca;
    protected String modelo;
    protected String version;
    protected String color;
    protected double año;
    protected double precioCompra; // Cambiado a protected para acceso en ArrayListAutos
    protected double precio;

    public Autos1(String nombrepers, String nserie, String marca, String modelo, String version, String color,
            double año, double precioCompra, double precio) {
        this.nombrepers = nombrepers;
        this.nserie = nserie;
        this.marca = marca;
        this.modelo = modelo;
        this.version = version;
        this.color = color;
        this.año = año;
        this.precioCompra = precioCompra;
        this.precio = precio;
    }

    public String getNombrepers() {
        return nombrepers;
    }

    public String getNserie() {
        return nserie;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getVersion() {
        return version;
    }

    public String getColor() {
        return color;
    }

    public double getAño() {
        return año;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precio;
    }

    @Override
    public String toString() {
        return "Número de Serie: " + nserie + ", Marca: " + marca + ", Modelo: " + modelo + ", Versión: " + version
                + ", Color: " + color + ", Año: " + año + ", Precio Venta: " + precio;
    }
}