/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Fer
*/

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Banco miBanco = null;
        int opcion;

        do {
            System.out.println("1. Crear Banco");
            System.out.println("2. Agregar Cuenta");
            System.out.println("3. Ingresar en Cuenta");
            System.out.println("4. Retirar de Cuenta");
            System.out.println("5. Ver Datos de Cuenta");
            System.out.println("6. Ver Informe Total del Banco");
            System.out.println("7. Borrar Cuenta");
            System.out.println("8. Salir");

            System.out.print("Selecciona una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    if (miBanco != null) {
                        System.out.println("Ya existe un banco, escribe (si) si quieres agregar uno nuevo, escribe cualquier otra cosa para cancelar");                        
                        String crearBanco = teclado.nextLine().toLowerCase();
                        if (crearBanco.equals("si")) {
                            System.out.print("Ingresa el nombre del banco: ");
                            String nombreBanco = teclado.nextLine();
                            if (nombreBanco.equals(miBanco.getNombre())) {
                                System.out.println("El banco que estás creando es el mismo que ya existe");
                            } else {
                                if (nombreBanco.length() <= 0) {
                                    System.out.println("El nombre del banco esta vacio");
                                } else {
                                    miBanco = new Banco(nombreBanco);
                                    System.out.println("El banco " + nombreBanco + " ha sido creado");
                                }
                            }
                        } else {
                            break;
                        }
                    } else {
                        System.out.print("Ingresa el nombre del banco: ");
                        String nombreBanco = teclado.nextLine();
                        if (nombreBanco.length() <= 0) {
                            System.out.println("El nombre del banco está vacío");
                        } else {
                            miBanco = new Banco(nombreBanco);
                            System.out.println("El banco " + nombreBanco + " ha sido creado");
                        }                        
                    }
                    break;
                case 2:
                    if (miBanco != null) {
                        System.out.print("Ingresa el IBAN de la cuenta: ");
                        String iban = teclado.nextLine();

                        System.out.print("Ingresa el DNI del titular: ");
                        String dni = teclado.nextLine().toUpperCase();

                        System.out.print("Ingresa el nombre del titular: ");
                        String titular = teclado.nextLine();
                        
                        System.out.print("Ingresa el correo electronico del titular: ");
                        String correo = teclado.nextLine().toLowerCase();

                        try {
                            if (Cuenta.validarDNI(dni) && Cuenta.validarCorreo(correo)) {
                                miBanco.agregarCuenta(iban, dni, titular, correo); // Se crea la cuenta
                                System.out.println("La cuenta " + iban + " del titular " + titular + " se ha agregado bien");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("No hay ningun banco creado");
                    }

                    break;
                case 3:
                    try {
                        if (miBanco != null) {
                            System.out.print("Ingresa IBAN de la cuenta: ");
                            String ibanIngreso = teclado.nextLine();
                            
                            System.out.print("Ingresa la cantidad a ingresar: ");
                            double cantidadIngreso = teclado.nextDouble();
                            teclado.nextLine();

                            if (miBanco.ingresar(ibanIngreso, cantidadIngreso)) {
                                System.out.println("Se han ingresado " + cantidadIngreso + "€. En total hay: " + miBanco.informaDeSaldo(ibanIngreso) + "€");
                            } else {
                                System.out.println("No se ha hecho el ingreso. Quiza has escrito mal el IBAN");
                            }
                        } else {
                            System.out.println("No hay ningun banco creado");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Debes escribir un numero");
                        System.out.println(e);
                        
                        teclado.nextLine();
                        System.out.println();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try {
                        if (miBanco != null) {
                            System.out.print("Ingresa el IBAN de la cuenta: ");
                            String ibanRetiro = teclado.nextLine();
                            
                            System.out.print("Ingresa la cantidad a retirar: ");
                            double cantidadRetiro = teclado.nextDouble();
                            teclado.nextLine();

                            if (miBanco.retirar(ibanRetiro, cantidadRetiro)) {
                                System.out.println("Se han retirado " + cantidadRetiro + "€. Queda en total: " + miBanco.informaDeSaldo(ibanRetiro) + "€");
                            } else {
                                System.out.println("No se ha retirado nada. Quiza has escrito mal el IBAN");
                            }
                        } else {
                            System.out.println("No hay ningun banco creado");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Debes escribir un numero");
                        System.out.println(e);
                        
                        teclado.nextLine();
                        System.out.println();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e);
                    }
                    break;
                case 5:
                    if (miBanco != null) {
                        System.out.print("Ingresa el IBAN de la cuenta: ");
                        String ibanConsulta = teclado.nextLine();
                        
                        System.out.println(miBanco.consultarCuenta(ibanConsulta));
                    } else {
                        System.out.println("No hay ningun banco creado");
                    }

                    break;
                case 6:
                    if (miBanco != null) {
                        System.out.println("Listado de cuentas:");
                        System.out.println(miBanco.listadoCuentas());
                    } else {
                        System.out.println("No hay ningun banco creado");
                    }

                    break;
                case 7:
                    if (miBanco != null) {
                        System.out.print("Ingresa el IBAN de la cuenta que quieres borrar: ");
                        String ibanBorrar = teclado.nextLine();
                        
                        if (miBanco.existeCuenta(ibanBorrar)) {
                            miBanco.borrarCuenta(ibanBorrar);
                            System.out.println("La cuenta con IBAN " + ibanBorrar + " ha sido borrada del banco " + miBanco.getNombre());
                        } else {
                            System.out.println("La cuenta que has introducido (" + ibanBorrar + ") no existe");
                        }
                    } else {
                        System.out.println("No hay ningun banco creado");
                    }

                    break;
                case 8:
                    break;
            }
        } while (opcion != 8);

        teclado.close();
    }
}
