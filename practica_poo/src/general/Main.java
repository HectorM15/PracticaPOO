package general;

import excepciones.CampoVacio;
import excepciones.FueraDeRangoMenu;
import excepciones.NoEsUnDNI;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String args[]) {
            Simulador simulator = new Simulador();
            simulator.iniciarPrograma();
    }
}
