/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package banco;

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
            return false;
        } else {
            this.cuentas[numeroCuentas++] = new Cuenta(codigo, nombreTitular);
            return true;
        }
    }
    
    public String consultarCuenta(String codigo) {
        StringBuilder consulta = new StringBuilder();

        for (int i = 0; i < numeroCuentas; i++) {
            if (cuentas[i].getIban().equals(codigo)) {
                consulta.append("IBAN: ").append(codigo).append("\t").append("Titular: ").append(cuentas[i].getTitular()).append("\t").append("Saldo: ").append(cuentas[i].getSaldo());
                return consulta.toString();
            }
        }

        consulta.append("La cuenta que has indicado no se ha encontrado");
        return consulta.toString();
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
            }
        }
        
        return cuentaEncontrada;
    }
    
    public boolean existeCuenta(String codigo) {       
        for (int i = 0; i < numeroCuentas; i++) {
            if (cuentas[i].getIban().equals(codigo)) { // obtiene el isbn de la posicion de cuenta y lo compara con el parametro que se le pasa al metodo
                return true;
            }
        }
        
        return false;
    }
    
    public String listadoCuentas() {
        StringBuilder listado = new StringBuilder();
        
        listado.append("Total de cuentas: ").append(numeroCuentas).append("\n");
        
        for (int i = 0; i < numeroCuentas; i++) {
            // esto se hace como cuando lo del ejercicio de las interfaces de usuario (creo xd)
            listado.append("IBAN: ").append(cuentas[i].getIban()).append("\t\t").append("Titular: ").append(cuentas[i].getTitular()).append("\t\t").append("Saldo: ").append(cuentas[i].getSaldo()).append("\n"); // lo siguiente junta todo con el append
        }
        
        return listado.toString();
    }
    
    public double informaDeSaldo(String iban) {
        if (existeCuenta(iban)) {
            for (int i = 0; i < numeroCuentas; i++) {
                if (cuentas[i].getIban().equals(iban)) {
                    return cuentas[i].getSaldo(); // Devuelve el saldo de la cuenta si existe
                }
            }
        }
        
        return -100000000; // Devuelve -100.000.000 si la cuenta no existe
    }
    
    public boolean ingresar(String codigo, double importe) {
        Cuenta cuenta = localizarCuenta(codigo);
        
        if (cuenta == null) {
            return false;
        } else {
            cuenta.ingresarDinero(importe);
            return true;
        }
    }
    
    public boolean retirar(String codigo, double importe) {
        Cuenta cuenta = localizarCuenta(codigo);
        
        if (cuenta == null) {
            return false;
        } else {
            cuenta.retirarDinero(importe);
            return true;
        }
    }
    
    // Fin Metodos Publicos
    
    
    // Inicio Metodos Privados
    
    // no se para que quiere este metodo xd
    private Cuenta localizarCuenta(String codigo) {
        for (int i = 0; i < numeroCuentas; i++) {
            if (cuentas[i].getIban().equals(codigo)) {
                return cuentas[i]; // Devolver la cuenta encontrada
            }
        }
        return null; // Devolver null si la cuenta no se encuentra
    }
    
    // Fin Metodos Privados
}
