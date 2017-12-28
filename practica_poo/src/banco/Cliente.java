package banco;

import excepciones.CampoVacioException;
import excepciones.NoEsUnDNIException;

import java.io.*;

public class Cliente extends Persona implements Serializable{

    protected Double saldo;
    private PaqueteDeAcciones paqueteDeAcciones;

    public Cliente(String DNI, String nombre, Double saldo) {
        super(DNI, nombre);
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        try{
            if (!saldo.isNaN() && saldo>0) {
                this.saldo = saldo;
            } else {
                throw new CampoVacioException("No le has asignado un saldo inicial al cliente o ha sido negativo");
            }
        }catch (CampoVacioException campoVacioException){
            System.out.println(campoVacioException.getMessage());
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
