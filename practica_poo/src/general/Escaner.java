package general;

import java.util.Scanner;

public class Escaner {
    private static Scanner sc = new Scanner(System.in);

    public void entradaCrearCliente(String dni,String nombre,Double saldo) {
        System.out.println("Introduzca el DNI del cliente que desea crear");
        dni = sc.next();
        System.out.println("Introduzca el nombre del cliente que desea crear");
        nombre = sc.next();
        System.out.println("Introduzca el saldo inical del cliente que desea crear");
        saldo = sc.nextDouble();
    }
}
