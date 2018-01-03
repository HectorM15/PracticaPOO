package general;

import banco.Cliente;
import excepciones.*;

public class ValidadorClientes extends ValidarPersona {

    public void validarCliente(Cliente persona) throws NoEsUnDNIException, CampoVacioException, SaldoNegativoVacioException {
        super.validarPersona(persona);
        if (persona.getSaldo() == null) {
            throw new CampoVacioException("El saldo es vacio");
        } else if (persona.getSaldo() < 0) {
            throw new SaldoNegativoVacioException("El saldo inicial no puede ser negativo");
        }
    }

    public void validarCompraAccionesCliente(Cliente persona, Double inversion) throws SaldoInsuficienteException {
        if (persona.getSaldo() < inversion) {
            throw new SaldoInsuficienteException("El saldo del cliente no es suficiente para realizar esta operación");
        }
    }

    public void validarVentaAccionesCliente(Cliente persona, Integer numeroAcciones, String nombreEmpresa) throws  NoHaySuficientesAccionesExceptions {
        if (persona.getPaqueteDeAcciones().getNumeroAccionesPorEmpresa(nombreEmpresa) == 0 || persona.getPaqueteDeAcciones().getNumeroAccionesPorEmpresa(nombreEmpresa) == null) {
            throw new NoHaySuficientesAccionesExceptions("No dispones de acciones sufcientes acciones de la empresa "+nombreEmpresa);
        }
    }
}
