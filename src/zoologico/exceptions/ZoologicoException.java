package zoologico.exceptions;

public class ZoologicoException extends Exception {
    public ZoologicoException(String message) {
        super(message);
    }
    public ZoologicoException(String message, Throwable cause) { super(message, cause); }
}
