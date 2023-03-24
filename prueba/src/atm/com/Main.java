package atm.com;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner inputUsuario = new Scanner(System.in);
        Integer opcion, moneda;
        Double saldoCordobas = 1000.00;
        Double saldoDolares = 100.00;

        Menu (saldoCordobas);

        do {
            System.out.println("Ingrese una opción:");
            opcion = Integer.parseInt(inputUsuario.nextLine());
            Scanner valorInput = new Scanner(System.in);
            Double valor;

            switch (opcion) {
                case 0:
                    System.out.println("Hasta Luego, gracias por usar el sistema");
                    break;
                case 1:
                    String saldoFormatoDecimal = new DecimalFormat("#.0#").format(saldoCordobas);
                    System.out.println("Su saldo actual es: " + saldoFormatoDecimal);
                    break;
                case 2:
                    System.out.println("Especifique la modenda para realizar la transacción:");
                    System.out.println("1) - Córdobas C$");
                    System.out.println("2) - Dólares $");
                    moneda = Integer.parseInt(valorInput.nextLine());

                    System.out.println("Ingrese el Monto:");
                    valor = Double.parseDouble(valorInput.nextLine());

                    DepositosCordobas deposito = new DepositosCordobas();

                    if( moneda == 1 ) { // cordoba
                        saldoCordobas = deposito.sumarDepositoCordobas(saldoCordobas, valor);
                        System.out.println("Su nuevo saldo en córdobas es: " + saldoCordobas);
                    } else if (moneda == 2) { // Dolares
                        OperacionesDolares depositoDol = new OperacionesDolares();
                        String deposito_mensaje  = depositoDol.Deposito(saldoDolares, valor);
                        System.out.println(deposito_mensaje);
                    } else {
                        System.out.println("Opción no válida");
                    }
                    break;
                case 3:
                    System.out.println("Especifique la modenda para realizar la transacción:");
                    System.out.println("1) - Córdobas C$");
                    System.out.println("2) - Dólares $");
                    moneda = Integer.parseInt(valorInput.nextLine());

                    System.out.println("Ingrese el Monto:");
                    valor = Double.parseDouble(valorInput.nextLine());

                    RetiroNacional retiro = new RetiroNacional();

                    if( moneda == 1 ) {
                        if(saldoCordobas > 0 && saldoCordobas >= valor) {
                            saldoCordobas = retiro.retiroCordoba(saldoCordobas, valor);
                            System.out.println("Su nuevo saldo en córdobas es: " + saldoCordobas);
                        } else {
                            System.out.println("No tiene suficiente dinero para retirar");
                        }
                    } else if (moneda == 2) {
                        OperacionesDolares retiroDol = new OperacionesDolares();
                        String retiro_mensaje  = retiroDol.Retiro(saldoDolares, valor);
                        System.out.println(retiro_mensaje);
                    } else {
                        System.out.println("Opción no válida");
                    }

                    break;
            }

        } while (opcion != 0);

    }

    public static void Menu (Double saldo) {
        System.out.println("Bienvenidos al sistema de ATM");
        String saldoFormatoDecimal = new DecimalFormat("#.0#").format(saldo);
        System.out.println("Su saldo actual es: " + saldoFormatoDecimal);
        System.out.println("Tiene a su disposición las siguientes gestiones:");
        System.out.println("Opción 1 - Consultar Saldo.");
        System.out.println("Opción 2 - Depósito de dinero.");
        System.out.println("Opción 3 - Retiro de dinero.");
        System.out.println("Opción 0 - Salir");
    }
}