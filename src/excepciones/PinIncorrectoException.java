package excepciones;

public class PinIncorrectoException extends Exception {
    public PinIncorrectoException(String mensaje) {
        super(mensaje);
    }
}
