
package com.mycompany.cajeroautomatico;
import javax.swing.JOptionPane;
/**
 *
 * @author Alumno 103
 */
public class CajeroAutomatico {

    //Atributos de clase
    private String titular;
    private String PIN;
    private double saldo;
 
    //Constructor
    public CajeroAutomatico(String titular, String PIN, double saldo) {
        this.titular = titular;
        this.PIN = PIN;
        if (saldo < 0) //Nos aseguramos que no se inicie con saldo negativo
            this.saldo = 0;
        else
            this.saldo = saldo;
    }
 
    //Métodos getter's y setter's
    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getPIN() {
    	return PIN;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setPIN(String PIN) {
    	this.PIN = PIN;
    }
 
    //Métodos para operar con la cuenta
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
        	saldo += cantidad;
        	System.out.println("\nOperacion completada.");
        }
        else
        	System.out.println("\nCantidad a ingresar ha de ser un monto positivo");
    }
 
    public void retirar(double cantidad) {
        if (saldo - cantidad < 0)
        	System.out.println("\nNo hay saldo suficiente para la retirada.");
        else {
        	saldo -= cantidad;
        	System.out.println("\nOperacion completada.");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
