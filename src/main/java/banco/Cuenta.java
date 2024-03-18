/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 * @author Fer
*/

public class Cuenta {
    private String iban;
    private String titular;
    private double saldo;
    
    // Inicio Constructor
    
    public Cuenta(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0;
    }
    
    public Cuenta() {
        this.iban = "";
        this.titular = "";
        this.saldo = 0;
    }
    
    // Fin Constructor
    
    // Inicio Getters y Setters

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    // Fin Getters y Setters
    
    public void ingresarDinero(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
        }
    }
    
    public void retirarDinero(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            this.saldo -= cantidad;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s, %-30s, %.2f", this.iban, this.titular, this.saldo);
    }
}
