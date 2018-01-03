package general;

import banco.Cliente;
import banco.ClientePremium;
import banco.Empresa;
import excepciones.FueraDeRangoMenuException;

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
                    throw new FueraDeRangoMenuException("Ha introducido una opción incorrecta.Debe introducir un número comprendido entre 0-18 ambos inclusive");
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
                            System.out.println("Introduzca el DNI del cliente que desea la solicitud");
                            String dni_cliente_premium = sc.next();
                            simulador.banco.recomendarInversion(dni_cliente_premium);
                            break;
                        case 9:
                            System.out.println("Introduzca el nombre de la empresa que desea crear");
                            String nombreEmpresa = sc.next();
                            System.out.println("Introduzca el valor de la cciones de la empresa");
                            Double valorAcciones = Double.valueOf(sc.next());
                            simulador.bolsaDeValores.añadirEmpresa(nombreEmpresa,valorAcciones);
                            break;
                        case 10:
                            System.out.println("Introduzca el nombre de la empresa que desea borrar");
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
                            System.out.println("Introduzca el DNI del cliente que va a realizar la operación de compra");
                            String clienteCompra = sc.next();
                            System.out.println("Introduzca el dinero que desea invertir");
                            Double inversion = Double.valueOf(sc.next());
                            System.out.println("Introduzca el nombre de la empresa en la que desea invertir");
                            String empresaInversion = sc.next();
                            simulador.banco.peticionCompraAcciones(clienteCompra,empresaInversion,inversion);
                            break;
                        case 15:
                            System.out.println("Introduzca el DNI del cliente que va a realizar la operación de compra");
                            String clienteVenta = sc.next();
                            System.out.println("Introduzca el numero de acciones que desea vender");
                            Integer numeroAcciones = Integer.valueOf(sc.next());
                            System.out.println("Introduzca el nombre de la empresa de la cual quiere vender acciones");
                            String empresaVenta = sc.next();
                            simulador.banco.peticionVentaDeAcciones(clienteVenta,empresaVenta,numeroAcciones);
                            break;
                        case 16:
                            // ACTUALIZAR VALORES
                            break;
                        case 17:
                            System.out.println("------------------ OPERACIONES PENDIENTES ---------------");
                            simulador.agenteDeInversiones.mostarColasOperaciones();
                            break;
                        case 18:
                            // EJECUTAR ACCIONES
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Ha introducido un caracter no válido.Debe introducir un número comprendido entre 0-18 ambos inclusive");
                sc.next();
            } catch (FueraDeRangoMenuException fueraDeRangoMenuException) {
                System.out.println(fueraDeRangoMenuException.getMessage());
            }
        }


    }

    private void pintarMenu(){
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
