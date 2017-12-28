package mensajes;

public class MensajeCompra extends Mensaje {
    private String cantidadInvertida;

    public MensajeCompra(Integer identificador, String realizador, String receptor, String cantidadInvertida) {
        super(identificador, realizador, receptor);
        this.cantidadInvertida=cantidadInvertida;
    }
}
