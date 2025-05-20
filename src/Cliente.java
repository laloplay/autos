import java.time.LocalDate;

public class Cliente {
    private String nombre;
    private String unidadComprada;
    private double costoDealership;
    private double precioVenta;
    private double ganancia;
    private LocalDate fechaCompra;

    public Cliente(String nombre, Autos1 auto, double costoDealership, double precioVenta, LocalDate fechaCompra) {
        this.nombre = nombre;
        this.unidadComprada = auto.getMarca() + " " + auto.getVersion() + " (" + auto.getColor() + ")";
        this.costoDealership = costoDealership;
        this.precioVenta = precioVenta;
        this.ganancia = precioVenta - costoDealership;
        this.fechaCompra = fechaCompra;
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

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
}