package banco;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import excepciones.*;
import general.ValidadorClientes;
import mensajes.Mensaje;
import mensajes.MensajeCompra;
import mensajes.MensajeVenta;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Banco {

    private String nombre;
    private HashMap<String, Cliente> hashMapCliente;
    private AgenteDeInversiones agenteDeInversiones;
    private Banco copiaBanco;
    private ValidadorClientes validadorClientes = new ValidadorClientes();

    public Banco(String nombre, HashMap<String, Cliente> hashMapCliente, AgenteDeInversiones agenteDeInversiones) {
        try {
            if (!nombre.isEmpty()) {
                this.nombre = nombre;
            } else {
                throw new CampoVacioException("Has dejado el nombre vacío");
            }
            if (hashMapCliente.size() > 0) {
                this.hashMapCliente = hashMapCliente;
            } else {
                throw new CampoVacioException("Has insertado una cartera de clientes vacía");
            }
            this.agenteDeInversiones = agenteDeInversiones;
        } catch (CampoVacioException campoVacioException) {
            System.out.println(campoVacioException.getMessage());
        }
    }

    public void copiaDeSeguridad(String ruta) throws IOException {
        FileOutputStream s = new FileOutputStream(ruta);
        ObjectOutputStream stream = new ObjectOutputStream(s);
        stream.defaultWriteObject();
        stream.writeObject(this);
    }

    public void restaurarCopiaDeSeguridad(String rutaCopia, Banco banco) throws IOException, ClassNotFoundException {
        FileInputStream s = new FileInputStream(rutaCopia);
        ObjectInputStream stream = new ObjectInputStream(s);
        banco = (Banco) stream.readObject();
    }

    public void crearCliente(String DNI, String nombre, double saldo) {
        try {
            Cliente clienteNuevo = new Cliente(DNI, nombre, saldo);
            validadorClientes.validarCliente(clienteNuevo);
            hashMapCliente.put(clienteNuevo.getDNI(), clienteNuevo);
        } catch (CampoVacioException | NoEsUnDNIException | SaldoNegativoVacioException e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarCliente(String dni) {
        if (hashMapCliente.get(dni) != null) {
            hashMapCliente.remove(dni);
            System.out.println("El cliente con DNI " + dni + " ha sido eliminado con exito");
        } else {
            System.out.println("No se ha encontrado al cliente con dni " + dni);
        }
    }

    public void mejorarClientePremium(String dni, AgenteDeInversiones agenteDeInversiones) {
        ClientePremium clientePremium = new ClientePremium(hashMapCliente.get(dni), agenteDeInversiones);
        hashMapCliente.remove(dni);
        hashMapCliente.put(clientePremium.getDNI(), clientePremium);
    }

    public void imprimirEstadoClientes() {
        //Pendiente revisión
        for (Map.Entry<String, Cliente> entry : hashMapCliente.entrySet()) {
            String key = entry.getKey();
            hashMapCliente.get(key).imprimirEstado();
        }
    }

    public AgenteDeInversiones getAgenteDeInversiones() {
        return agenteDeInversiones;
    }

    public void peticionCompraAcciones(String dni,String empresa, Double inversion) {
        Cliente cliente = hashMapCliente.get(dni);
        try {
            validadorClientes.validarCompraAccionesCliente(cliente,inversion);
            MensajeCompra mensajeCompra= new MensajeCompra(agenteDeInversiones.getIdentificadorOperaciones(),cliente.getNombre(),empresa,inversion.toString());
            if (cliente instanceof ClientePremium == false) {
                ((ClientePremium)cliente).getAgenteDeInversiones().añadirOperacionALaCola(mensajeCompra);
            } else {
                this.getAgenteDeInversiones().añadirOperacionALaCola(mensajeCompra);
            }
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    public void peticionVentaDeAcciones(String dni,String empresa, Integer numeroAcciones){
        Cliente cliente = hashMapCliente.get(dni);
        try {
            validadorClientes.validarVentaAccionesCliente(cliente,numeroAcciones,empresa);
            MensajeVenta mensajeVenta= new MensajeVenta(agenteDeInversiones.getIdentificadorOperaciones(),cliente.getDNI(),empresa,numeroAcciones);
            if (cliente instanceof ClientePremium == false) {
                ((ClientePremium)cliente).getAgenteDeInversiones().añadirOperacionALaCola(mensajeVenta);
            } else {
                this.getAgenteDeInversiones().añadirOperacionALaCola(mensajeVenta);
            }
        } catch (NoHaySuficientesAccionesExceptions noHaySuficientesAccionesExceptions) {
            System.out.println(noHaySuficientesAccionesExceptions.getMessage());
        }
    }

    public void recomendarInversion(String dni) {
        Object cliente = hashMapCliente.get(dni);
        if (cliente == null) {
            System.out.println("El cliente que has introducido no existe");
        } else if (cliente instanceof ClientePremium == false) {
            System.out.println("El cliente seleccionado no es premium");
        } else {
            Empresa empresa = ((ClientePremium) cliente).getAgenteDeInversiones().getMejorIncremento();
            System.out.println("La empresa : " + empresa.getNombre());
            System.out.println("Con un valor de acciones: " + empresa.getValorAcciones());
            System.out.println("Y un incremento de : " + empresa.getIncremento());
            System.out.println("Es la mejor opcion para invertir");
        }
    }

    public void copiaDeSeguridad() {
    }
}
