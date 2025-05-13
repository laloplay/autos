public class Seminuevos extends Autos1 {
    private double kilometraje;
    private int cantidadDueños;
    private String nacionalidad;

    public Seminuevos(double kilometraje, double año, int cantidadDueños, String nacionalidad,
            String nombrepers, String nserie, String marca, String modelo, String version, String color, double precio,
            double precioCompra) {
        super(nombrepers, nserie, marca, modelo, version, color, año, precioCompra, precio);
        this.kilometraje = kilometraje;
        this.cantidadDueños = cantidadDueños;
        this.nacionalidad = nacionalidad;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public int getCantidadDueños() {
        return cantidadDueños;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return super.toString() + ", Kilometraje: " + kilometraje + " km, Dueños anteriores: " + cantidadDueños
                + ", Nacionalidad: " + nacionalidad;
    }
}