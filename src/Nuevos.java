public class Nuevos extends Autos1 {
    private int garantia;
    private String accesorios;
    private double enganche;

    public Nuevos(int garantia, String accesorios, String marca, String modelo, String version, double enganche,
            String nombrepers, String nserie, String color, double precio, double año, double precioCompra) {
        super(nombrepers, nserie, marca, modelo, version, color, año, precioCompra, precio);
        this.garantia = garantia;
        this.accesorios = accesorios;
        this.enganche = enganche;
    }

    public int getGarantia() {
        return garantia;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public double getEnganche() {
        return enganche;
    }

    @Override
    public String toString() {
        return super.toString() + ", Garantía: " + garantia + " años, Accesorios: " + accesorios + ", Enganche: "
                + enganche;
    }
}