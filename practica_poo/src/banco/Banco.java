package banco;

import excepciones.CampoVacio;
import excepciones.NoEsUnDNI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Banco {

    private String nombre;
    private HashMap<String, Cliente> hashMapCliente;
    private AgenteDeInversiones agenteDeInversiones;
    private Banco copiaBanco;

    public Banco(String nombre, HashMap<String, Cliente> hashMapCliente, AgenteDeInversiones agenteDeInversiones) {
        try {
            if (!nombre.isEmpty()) {
                this.nombre = nombre;
            } else {
                throw new CampoVacio("Has dejado el nombre vacío");
            }
            if (hashMapCliente.size() > 0) {
                this.hashMapCliente = hashMapCliente;
            } else {
                throw new CampoVacio("Has insertado una cartera de clientes vacía");
            }
            this.agenteDeInversiones = agenteDeInversiones;
        } catch (CampoVacio campoVacio) {
            System.out.println(campoVacio.getMessage());
        }
    }

    public void copiaDeSeguridad(String ruta) throws IOException {
        FileOutputStream s = new FileOutputStream(ruta);
        ObjectOutputStream stream = new ObjectOutputStream (s);
        stream.defaultWriteObject();
        stream.writeObject(this);
    }

    public void restaurarCopiaDeSeguridad(String rutaCopia, Banco banco) throws IOException, ClassNotFoundException {
        FileInputStream s = new FileInputStream(rutaCopia);
        ObjectInputStream stream = new ObjectInputStream (s);
        banco = (Banco) stream.readObject();
    }

    public void crearCliente(String DNI, String nombre, double saldo) {
        Cliente clienteNuevo = new Cliente(DNI, nombre, saldo);
        hashMapCliente.put(clienteNuevo.getDNI(), clienteNuevo);
    }

    public void eliminarCliente(String dni) {
        try {
            hashMapCliente.remove(dni);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    public void recomendarInversion() {

    }

    public void copiaDeSeguridad() {
    }
}
