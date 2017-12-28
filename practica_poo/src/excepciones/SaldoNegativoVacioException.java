package excepciones;

public class SaldoNegativoVacioException extends Exception {

    public SaldoNegativoVacioException(String message) {
        super(message);
    }

    public SaldoNegativoVacioException(String message, Throwable cause) {
        super(message, cause);
    }
}
