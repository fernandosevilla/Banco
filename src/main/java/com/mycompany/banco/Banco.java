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
                return "Titular: " + codigo + "\t" + "Saldo: " + cuentas[i].getSaldo();
            }
        }
        return "La cuenta que has indicado no se ha encontrado";
    }
    
    private Cuenta localizarCuenta(String codigo) {
        // se busca secuencialmente la cuenta con un codigo
        Cuenta cuenta = new Cuenta();
        for (int i = 0; i < numeroCuentas; i++) {
            if (cuentas[i].getIban().equals(codigo)) {
                return cuenta;
            }
        }
        return null;
    }
}
