/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.banco;

/**
 * @author Fer
*/

public class Banco {

    private String nombre;
    private static Cuenta[] cuentas;
    private int numeroCuentas;
    private static final int MAX_CUENTAS = 100;
    
    // Inicio Constructor
    
    public Banco(String nombre) {
        this.nombre = nombre;
        this.cuentas = new Cuenta[MAX_CUENTAS];
        this.numeroCuentas = 0;
    }
    
    // Fin Constructor
    
    // Inicio Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Cuenta[] getCuentas() {
        return cuentas;
    }

    public static void setCuentas(Cuenta[] cuentas) {
        Banco.cuentas = cuentas;
    }

    public int getNumeroCuentas() {
        return numeroCuentas;
    }

    public void setNumeroCuentas(int numeroCuentas) {
        this.numeroCuentas = numeroCuentas;
    }

    // Fin Getters y Setters
    
    // Inicio Metodos Publicos
    public boolean agregarCuenta(String codigo, String nombreTitular) {
        if (this.numeroCuentas > MAX_CUENTAS) {
            System.out.println("No puedes crearte mas de 100 cuentas");
            return false;
        } else {
            this.cuentas[numeroCuentas++] = new Cuenta(codigo, nombreTitular);
            System.out.println("Cuenta creada");
            return true;
        }
    }
    
    public String consultarCuenta(String codigo) {
        for (int i = 0; i < numeroCuentas; i++) {
            if (cuentas[i].getIban().equals(codigo)) {
                return "IBAN: " + codigo + "\t" + "Titular: " + cuentas[i].getTitular() + "\t" + "Saldo: " + cuentas[i].getSaldo();
            }
        }
        return "La cuenta que has indicado no se ha encontrado";
    }
    
    public boolean borrarCuenta(String codigo) {
        boolean cuentaEncontrada = false;
        
        for (int i = 0; i < numeroCuentas; i++) {
            if (cuentas[i].getIban().equals(codigo)){ // obtiene el ibjn de la posicion de cuenta y lo compara con el parametro que se le pasa al metodo
                cuentaEncontrada = true;
                
                // movemos las cuentas despues de borrar
                for (int j = i; j < numeroCuentas - 1; j++) {
                    cuentas[j] = cuentas [j + 1];
                }
                
                numeroCuentas--;
                System.out.println("Cuenta eliminada");
            }
        }
        if (cuentaEncontrada = false) {
            System.out.println("Cuenta no encontrada");
        }
        
        return cuentaEncontrada;
    }
    
    public boolean existeCuetna(String codigo) {       
        for (int i = 0; i < numeroCuentas; i++) {
            if (cuentas[i].getIban().equals(codigo)) { // obtiene el ibjn de la posicion de cuenta y lo compara con el parametro que se le pasa al metodo
                System.out.println("La cuenta existe"); 
                return true;
            }
        }
        
        System.out.println("La cuenta no existe");
        return false;
    }
    
    public String listadoCuentas() {
        StringBuilder listado = new StringBuilder();
        
        listado.append("Total de cuentas: ").append(numeroCuentas).append("):\n");
        
        for (int i = 0; i < numeroCuentas; i++) {
            // esto se hace como cuando lo del ejercicio de las interfaces de usuario (creo xd)
            listado.append("IBAN: ").append(cuentas[i].getIban()).append("\t\t").append("Titular: ").append(cuentas[i].getTitular()).append("\t\t").append("Saldo: ").append(cuentas[i].getSaldo()).append("\n"); // lo siguiente junta todo con el append
        }
        
        return listado.toString();
    }
    
    public void ingresar(String codigo, double importe) {
        // falta por hacer
    }
    
    public void retirar(String codigo, double importe) {
        // falta por hacer
    }
    
    // Fin Metodos Publicos
    
    
    // Inicio Metodos Privados
    
//    private Cuenta localizarCuenta(String codigo) {
//        // se busca secuencialmente la cuenta con un codigo
//        Cuenta cuenta = new Cuenta();
//        for (int i = 0; i < numeroCuentas; i++) {
//            if (cuentas[i].getIban().equals(codigo)) { // obtiene el ibjn de la posicion de cuenta y lo compara con el parametro que se le pasa al metodo
//                return cuenta; // devuelve la cuenta
//            }
//        }
//        return null;
//    }
    
    // no se para que quiere este metodo xd
    private Cuenta localizarCuenta(String codigo) {
        Cuenta cuenta = new Cuenta();
        
        if (existeCuetna(codigo)) {
            return cuenta;
        }
        
        return null;
    }
    
    // Fin Metodos Privados
}
