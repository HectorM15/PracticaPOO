package banco;

public class ClientePremium extends Cliente {

    private AgenteDeInversiones agenteDeInversiones;


    public ClientePremium(Cliente cliente,AgenteDeInversiones agenteDeInversiones){
        super(cliente.getDNI(), cliente.nombre, cliente.getSaldo());
        this.agenteDeInversiones=agenteDeInversiones;
    }

    @Override
    public void imprimirEstado() {
        System.out.println("----------- SOY PREMIUM ----------------");
        super.imprimirEstado();
        System.out.println("Mi broker es: "+agenteDeInversiones.getNombre());

    }

    public AgenteDeInversiones getAgenteDeInversiones() {
        return agenteDeInversiones;
    }
}
