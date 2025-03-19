/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista_Doblemente_Enlazada;

/**
 *
 * @author 50232
 */
public class Lista {

    private Nodo cabeza;
    
    public Lista() {
        this.cabeza = null;
    }
    
    // Método para agregar un nodo al final de la lista
    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        
        //Primer caso
        //Se va a insertar un primer dato
        if (cabeza == null) {
            cabeza = nuevoNodo;
            return;
        }
        
        //Segundo caso
        //Se va a intertar cuando ya existe almenos un dato
        Nodo actual = cabeza;
        Nodo current = cabeza;
        while (actual.siguiente != null) {
            //Guarde el nodo actual
            current = actual;
            //Cambio el puntero
            actual = actual.siguiente;
            //Al atributo anterior del nuevo nodo vacio le cambio valor
            actual.anterior=current;
            
        }
        actual.siguiente = nuevoNodo;
    }
    
    public void printBefore(int value){
        Nodo actual = cabeza;
        while (actual != null){
            if (actual.dato==value){
                System.out.println("El anterior a "+value+" es:"+actual.anterior.dato);
                actual=actual.siguiente;
            }
            actual=actual.siguiente;

        }
      
    }
    
    // Método para imprimir la lista
    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
