package mensajes;

public class MensajeVenta extends Mensaje {
    private Integer numeroAccionesEnVenta;

    public MensajeVenta(Integer identificador, String realizador, String receptor,Integer numeroAccionesEnVenta) {
        super(identificador, realizador, receptor);
        this.numeroAccionesEnVenta=numeroAccionesEnVenta;
    }

    public Integer getNumeroAccionesEnVenta() {
        return numeroAccionesEnVenta;
    }
}
