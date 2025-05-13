public class Cliente {
    private String nombre;
    private String unidadComprada;
    private double precioCompra;
    private double precioVenta;
    private double ganancia;

    public Cliente(String nombre, Autos1 auto, double precioCompra, double precioVenta) {
        this.nombre = nombre;
        this.unidadComprada = auto.getMarca() + " " + auto.getVersion() + " (" + auto.getColor() + ")";
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.ganancia = precioVenta - precioCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidadComprada() {
        return unidadComprada;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public double getGanancia() {
        return ganancia;
    }
}