package general;

import excepciones.FueraDeRangoMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfazDeUsuario {

    private static Scanner sc = new Scanner(System.in);

    public void imprimirMenu(Simulador simulador)  {
        Boolean salir = false;
        Integer opcion;
        while (!salir) {
            pintarMenu();
            try {
                opcion = sc.nextInt();
                if (opcion < 0 || opcion > 18) {
                    throw new FueraDeRangoMenu("Ha introducido una opción incorrecta.Debe introducir un número comprendido entre 0-18 ambos inclusive");
                } else {
                    switch (opcion) {
                        case 0:
                            salir = true;
                            break;
                        case 1:
                            simulador.banco.imprimirEstadoClientes();
                            break;
                        case 2:
                            simulador.bolsaDeValores.imprimirEstadoBolsa();
                            break;
                        case 3:
                            System.out.println("Introduzca el DNI del cliente que desea crear");
                            String dni = sc.next();
                            System.out.println("Introduzca el nombre del cliente que desea crear");
                            String nombre = sc.next();
                            System.out.println("Introduzca el saldo inical del cliente que desea crear");
                            Double saldo = Double.valueOf(sc.next());

                            simulador.banco.crearCliente(dni, nombre, saldo);
                            break;
                        case 4:
                            System.out.println("Introduzca el DNI del cliente que desea borrar");
                            String dni_ = sc.next();
                            simulador.banco.eliminarCliente(dni_);
                            break;
                        case 5:
                          //  simulador.banco.copiaDeSeguridad();
                            break;
                        case 6:
                          //  simulador.banco.restaurarCopiaDeSeguridad();
                            break;
                        case 7:
                            System.out.println("Introduzca el DNI del cliente que desea ampliar a premium");
                            String dni_premium = sc.next();
                            simulador.banco.mejorarClientePremium(dni_premium,simulador.agenteDeInversiones);
                            break;
                        case 8:
                            simulador.banco.recomendarInversion();
                            break;
                        case 9:
                            System.out.println("Introduzca el DNI del cliente que desea crear");
                            String nombreEmpresa = sc.next();
                            System.out.println("Introduzca el nombre del cliente que desea crear");
                            Float valorAcciones = sc.nextFloat();
                            simulador.bolsaDeValores.añadirEmpresa(nombreEmpresa,valorAcciones);
                            break;
                        case 10:
                            System.out.println("Introduzca el DNI del cliente que desea borrar");
                            String empresa = sc.next();
                            simulador.bolsaDeValores.eliminarEmpresa(empresa);
                            break;
                        case 11:
                            simulador.bolsaDeValores.actualizarValores();
                            break;
                        case 12:
                         //   simulador.bolsaDeValores.copiaDeSeguridad();
                            break;
                        case 13:
                          //  simulador.bolsaDeValores.restaurarCopiaDeSeguridad();
                            break;
                        case 14:

                            break;
                        case 15:

                            break;
                        case 16:

                            break;
                        case 17:

                            break;
                        case 18:

                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Ha introducido un caracter no válido.Debe introducir un número comprendido entre 0-18 ambos inclusive");
                sc.next();
            } catch (FueraDeRangoMenu fueraDeRangoMenu) {
                System.out.println(fueraDeRangoMenu.getMessage());
            }
        }


    }
    private  void pintarMenu(){
        System.out.println("SEÑALE LA OPCIÓN QUE DESEE REALIZAR");
        System.out.println("0.- Salir");
        System.out.println("-------------- ESTADO ---------------------");
        System.out.println("1.- Imprimir estado de los clientes");
        System.out.println("2.- Imprimir estado de la bolsa");
        System.out.println("-------------- BANCO ---------------------");
        System.out.println("3.- Añadir cliente");
        System.out.println("4.- Eliminar cliente");
        System.out.println("5.- Realizar copia de seguridad");
        System.out.println("6.- Restaurar copia de seguridad");
        System.out.println("7.- Mejorar cliente a premium");
        System.out.println("8.- Solicitar recomendación de inversión");
        System.out.println("-------------- BOLSA ---------------------");
        System.out.println("9.- Añadir empresa a la bolsa");
        System.out.println("10.- Eliminar empresa de la bolsa");
        System.out.println("11.- Actualización de valores");
        System.out.println("12.- Realizar copia de seguridad");
        System.out.println("13.- Restaurar copia de seguridad");
        System.out.println("-------------- OPERACIONES ---------------------");
        System.out.println("14.- Solicitar compra de acciones");
        System.out.println("15.- Solicitar venta de acciones");
        System.out.println("16.- Solicitar actualización de valores");
        System.out.println("-------------- BRÓKER ---------------------");
        System.out.println("17.- Imprimir operaciones pendientes");
        System.out.println("18.- Ejecutar operaciones pendientes");
    }

}
