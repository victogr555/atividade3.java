package zoologico.exceptions;

public class AmbienteException extends Exception {
    public AmbienteException(String message) {
        super(message);
    }
    public AmbienteException(String message, Throwable cause) { super(message, cause);}
}
