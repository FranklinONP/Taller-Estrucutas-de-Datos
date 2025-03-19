/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista_Doblemente_Enlazada_Circular;

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
        
       Lista_Doblemente_Enlazada_Circular.Lista lista = new Lista_Doblemente_Enlazada_Circular.Lista();
        
        // Agregar elementos
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        
        // Imprimir la lista
        System.out.println("Lista completa:");
        lista.imprimir();

        // Buscar el nodo anterior a un valor
        System.out.println("\nBuscando el nodo anterior:");
        lista.printBefore(3); // Debería imprimir "El anterior a 3 es: 2"
        lista.printBefore(1); // Debería imprimir "El anterior a 1 es: 4" (circular)
        lista.printBefore(5); // Debería indicar que no se encuentra
    
    }
    
}