package banco;

import excepciones.CampoVacio;
import excepciones.NoEsUnDNI;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.BooleanSupplier;

public class BolsaDeValores implements Serializable{

    private ArrayList<Empresa> arrayListEmpresa = new ArrayList<>();

    public BolsaDeValores(ArrayList<Empresa> arrayListEmpresa) {
        this.arrayListEmpresa = arrayListEmpresa;
    }

    public void imprimirEstadoBolsa() {
        System.out.println(" \n\n----------- ESTADO DE LA BOLSA ---------------");
        for (Empresa empresa : arrayListEmpresa) {
            System.out.println("La empresa '" + empresa.getNombre() + "' tiene unas acciones: ");
            if (empresa.getValorAcciones() > 0)
                System.out.println("Con beneficios del " + empresa.getValorAcciones());
            else if (empresa.getValorAcciones() < 0)
                System.out.println("Con perdidas del " + empresa.getValorAcciones());
            else
                System.out.println("Que se mantienen");

            System.out.println("-------------------------------------");
        }
        System.out.println("----------- FIN ESTADO DE LA BOLSA ---------------\n\n");

    }

    public void añadirEmpresa(String nombreEmpresa, Float valorAcciones) {
        Empresa empresaNueva = new Empresa(nombreEmpresa, valorAcciones);
        arrayListEmpresa.add(empresaNueva);
    }

    public void eliminarEmpresa(String nombreEmpresa) {
        for (Empresa empresa : arrayListEmpresa) {
            if (empresa.getNombre() == nombreEmpresa) {
                arrayListEmpresa.remove(empresa);
            }
        }
    }

    public void actualizarValores(){

    }

    public void copiaDeSeguridad(String ruta) throws IOException {
        FileOutputStream s = new FileOutputStream(ruta);
        ObjectOutputStream stream = new ObjectOutputStream (s);
        stream.defaultWriteObject();
        stream.writeObject(this);
    }

    public void restaurarCopiaDeSeguridad(String rutaCopia, BolsaDeValores bolsaDeValores) throws IOException, ClassNotFoundException {
        FileInputStream s = new FileInputStream(rutaCopia);
        ObjectInputStream stream = new ObjectInputStream (s);
        bolsaDeValores= (BolsaDeValores) stream.readObject();

    }
}
