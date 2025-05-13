public class Cliente {
    private String nombre;
    private String unidadComprada;
    private double costoDealership; // Costo para el concesionario (precio de compra del auto)
    private double precioVenta; // Precio al que se vendió al cliente
    private double ganancia;

    public Cliente(String nombre, Autos1 auto, double costoDealership, double precioVenta) {
        this.nombre = nombre;
        this.unidadComprada = auto.getMarca() + " " + auto.getVersion() + " (" + auto.getColor() + ")";
        this.costoDealership = costoDealership;
        this.precioVenta = precioVenta;
        this.ganancia = precioVenta - costoDealership;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidadComprada() {
        return unidadComprada;
    }

    public double getCostoDealership() {
        return costoDealership;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public double getGanancia() {
        return ganancia;
    }
}