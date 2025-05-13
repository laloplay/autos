public class PrecioInvalidoException extends Exception { // hereda de  exception por que es una excepcion personaliazda

    private double precioInvalido;

    public PrecioInvalidoException() {
        super();
    }

    public PrecioInvalidoException(String mensaje) {
        super(mensaje);
    }

    public PrecioInvalidoException(String mensaje, double precioInvalido) {
        super(mensaje);
        this.precioInvalido = precioInvalido;
    }

    public PrecioInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public double getPrecioInvalido() {
        return precioInvalido;
    }
}