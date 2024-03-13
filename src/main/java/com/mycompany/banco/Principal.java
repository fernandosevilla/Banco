/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;

import java.util.Scanner;

/**
 * @author Fer
*/

// ESTA CLASE Y MAIN ES PROVISIONAL HASTA QUE NOS DIGA ANTONIO QUE HACER CON EL PRINCIPAL

// SOLO ES DE PRUEBA //

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Banco miBanco = new Banco("Mi Banco");
        int opcion;

        do {
            System.out.println("1. Agregar cuenta");
            System.out.println("2. Consultar cuenta");
            System.out.println("3. Listar cuentas");
            System.out.println("4. Retirar dinero");
            System.out.println("5. Ingresar dinero");
            System.out.println("6. Borrar cuenta");
            System.out.println("0. Salir");

            System.out.print("Selecciona una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el IBAN de la cuenta: ");
                    String iban = teclado.nextLine();
                    System.out.print("Ingresa el titular de la cuenta: ");
                    String titular = teclado.nextLine();
                    miBanco.agregarCuenta(iban, titular);
                    break;
                case 2:
                    System.out.print("Ingresa el IBAN de la cuenta: ");
                    String ibanConsulta = teclado.nextLine();
                    System.out.println(miBanco.consultarCuenta(ibanConsulta));
                    break;
                case 3:
                    System.out.println("Listado de cuentas:");
                    System.out.println(miBanco.listadoCuentas());
                    break;
                case 4:
                    System.out.print("Ingresa el IBAN de la cuenta: ");
                    String ibanRetiro = teclado.nextLine();
                    System.out.print("Ingresa la cantidad a retirar: ");
                    double montoRetiro = teclado.nextDouble();
                    teclado.nextLine();
                    miBanco.retirar(ibanRetiro, montoRetiro);
                    break;
                case 5:
                    System.out.print("Ingresa IBAN de la cuenta: ");
                    String ibanIngreso = teclado.nextLine();
                    System.out.print("Ingresa la cantidad a ingresar: ");
                    double montoIngreso = teclado.nextDouble();
                    teclado.nextLine();
                    miBanco.ingresar(ibanIngreso, montoIngreso);
                    break;
                case 6:
                    System.out.print("Ingresa el IBAN de la cuenta que quieres borrar: ");
                    String ibanBorrar = teclado.nextLine();
                    miBanco.borrarCuenta(ibanBorrar);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("La opcion no es valida.");
            }
        } while (opcion != 0);

        teclado.close();
    }
}
