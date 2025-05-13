public class Cliente {
    private String nombre;
    private String unidadComprada;
    private double precioCompra;

    public Cliente(String nombre, Autos1 auto, double precioCompra) {
        this.nombre = nombre;
        this.unidadComprada = auto.getMarca() + " " + auto.getVersion() + " (" + auto.getColor() + ")";
        this.precioCompra = precioCompra;
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
}