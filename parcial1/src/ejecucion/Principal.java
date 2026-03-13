package ejecucion;

import parcial1.*;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cuenta cuenta = new Cuenta("12345", 435000, "Ahorros");
        Cajero cajero = new Cajero("C001", "bamcolombia");
        Seguridad seguridad = new Seguridad("1234");

        System.out.print("Ingrese su clave: ");
        String clave = sc.nextLine();

        if(!seguridad.validarClave(clave)){
            System.out.println("Clave incorrecta");
            return;
        }

        int opcion;

        do {

            System.out.println("\n--1 MENU --");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Salir");

            opcion = sc.nextInt();

            switch(opcion){

                case 1:
                    System.out.println("Saldo actual: " + cuenta.consultarSaldo());
                    break;

                case 2:

                    System.out.print("cantidad a retirar: ");
                    double monto = sc.nextDouble();

                    if(cajero.validarRetiro(monto, cuenta)){
                        cuenta.retirar(monto);
                        cajero.registrarOperacion();

                        Operacion op = new Operacion("Retiro", monto);
                        Comprobante comp = op.generarComprobante(cuenta.consultarSaldo());
                        comp.imprimir();

                    }else{
                        System.out.println("Retiro no permitido");
                    }

                    break;

            }

        }while(opcion != 3);

    }
}