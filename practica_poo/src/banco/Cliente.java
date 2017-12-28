package banco;

import excepciones.CampoVacio;
import excepciones.NoEsUnDNI;
import general.Utilidades;

import java.io.*;

public class Cliente extends Persona implements Serializable{

    protected Double saldo;
    private PaqueteDeAcciones paqueteDeAcciones;

    public Cliente(String DNI, String nombre, Double saldo) throws CampoVacio,NoEsUnDNI {
        super(DNI, nombre);
        try{
        if (!saldo.isNaN() && saldo>0) {
            this.saldo = saldo;
        } else {
            throw new CampoVacio("No le has asignado un saldo inicial al cliente o ha sido negativo");
        }
        }catch (CampoVacio campoVacio){
            System.out.println(campoVacio.getMessage());
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        try{
            if (!saldo.isNaN() && saldo>0) {
                this.saldo = saldo;
            } else {
                throw new CampoVacio("No le has asignado un saldo inicial al cliente o ha sido negativo");
            }
        }catch (CampoVacio campoVacio){
            System.out.println(campoVacio.getMessage());
        }
    }

    public void imprimirEstado() {
        System.out.println("----------- Cliente : "+ this.getNombre()+" --------------");
        System.out.println("DNI : " + this.getDNI() + " \n" +
                "Nombre :" + this.getNombre() + " \n" +
                "Saldo en efectivo:" + this.getSaldo() + " \n");
        //FALTA VALOR DE LOS PAQUETES DE ACCIONES
    }


}
