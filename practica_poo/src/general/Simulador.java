package general;

import banco.*;
import excepciones.CampoVacio;
import excepciones.FueraDeRangoMenu;
import excepciones.NoEsUnDNI;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulador {

    private InterfazDeUsuario interfazDeUsuario = new InterfazDeUsuario();
    public BolsaDeValores bolsaDeValores;
    public Banco banco;
    public AgenteDeInversiones agenteDeInversiones;

    public Simulador(){
        crearDatosClienteEmpresasBrokers();
    }

    public void iniciarPrograma(){
        interfazDeUsuario.imprimirMenu(this);
    }

    private void crearDatosClienteEmpresasBrokers() {
        Empresa empresa_1= new Empresa("Empresa 1", (float) 3.4);
        Empresa empresa_2= new Empresa("Empresa 2",(float) -3.4);
        Empresa empresa_3= new Empresa("Empresa 3",(float) 4.4);
        Empresa empresa_4= new Empresa("Empresa 4",(float) 1.4);
        ArrayList<Empresa> arrayListEmpresas= new ArrayList<>();

        arrayListEmpresas.add(empresa_1);
        arrayListEmpresas.add(empresa_2);
        arrayListEmpresas.add(empresa_3);
        arrayListEmpresas.add(empresa_4);

        Cliente cliente_1= new Cliente("47473202Y","Perico",1000.00);
        Cliente cliente_2= new Cliente("47473203F","Paquito",2000.00);
        Cliente cliente_3= new Cliente("47473204P","Bonifacio",3000.00);
        HashMap<String ,Cliente> hashMapClientela= new HashMap<>();

        hashMapClientela.put(cliente_1.getDNI(),cliente_1);
        hashMapClientela.put(cliente_2.getDNI(),cliente_2);
        hashMapClientela.put(cliente_3.getDNI(),cliente_3);

        agenteDeInversiones= new AgenteDeInversiones("47473201M","Jordan Belfort");

        bolsaDeValores= new BolsaDeValores(arrayListEmpresas);

        banco= new Banco("BBVA",hashMapClientela,agenteDeInversiones);
    }
}
