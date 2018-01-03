package excepciones;

public class NoHaySuficientesAccionesExceptions extends  Exception {
    public NoHaySuficientesAccionesExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public NoHaySuficientesAccionesExceptions(String message) {
        super(message);
    }
}
