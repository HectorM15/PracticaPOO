package banco;

import java.util.HashMap;

public class PaqueteDeAcciones {
    private HashMap<String, Integer> hashMapAcciones;

    public PaqueteDeAcciones(HashMap<String, Integer> hashMapAcciones) {
        this.hashMapAcciones = hashMapAcciones;
    }

    public void añadirAcciones(String nombreEmpresa, Integer numeroAcciones) {
        hashMapAcciones.put(nombreEmpresa, numeroAcciones);
    }

    public Integer getNumeroAccionesPorEmpresa(String nombreEmpresa) {
        Integer numeroDeAcciones = hashMapAcciones.get(nombreEmpresa);
        return numeroDeAcciones;
    }
}
