/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista_Doblemente_Enlazada;

/**
 *
 * @author 50232
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Lista lista = new Lista();
        
        // Agregar elementos
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        
        // Imprimir la lista
        lista.imprimir(); // Salida: 1 -> 2 -> 3 -> 4 -> null
        
        System.out.println("========================");
        lista.printBefore(3);
        lista.printBefore(1);
        
        lista.graficar("");
    
    }
    
}