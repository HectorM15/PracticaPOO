package banco;

import mensajes.Mensaje;

import java.util.HashMap;
import java.util.LinkedList;

public class AgenteDeInversiones extends Persona  {
    private BolsaDeValores bolsaDeValores;
    private LinkedList<Mensaje> colaOperacionesPendientes;

    public Integer getIdentificadorOperaciones() {
        return identificadorOperaciones;
    }

    private Integer identificadorOperaciones=5050;

    public AgenteDeInversiones(String DNI, String nombre,BolsaDeValores bolsaDeValores) {
        super(DNI, nombre);
        this.bolsaDeValores = bolsaDeValores;
        this.colaOperacionesPendientes = new LinkedList();
    }

    public void añadirOperacionALaCola(Mensaje operacion){
        colaOperacionesPendientes.addLast(operacion);
        identificadorOperaciones++;
    }

    public Empresa getMejorIncremento(){
        Double mayor = 0.00;
        Empresa mejorIncremento = null;
        for (Empresa empresa:bolsaDeValores.getArrayListEmpresa()) {
            if(empresa.getIncremento()>mayor){
                mejorIncremento=empresa;
            }else{
                mayor=empresa.getIncremento();
            }
        }
        return mejorIncremento;
    }
}
