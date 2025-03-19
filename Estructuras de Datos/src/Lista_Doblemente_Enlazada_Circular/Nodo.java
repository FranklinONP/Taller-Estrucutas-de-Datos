/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista_Doblemente_Enlazada_Circular;

/**
 *
 * @author 50232
 */
public class Nodo {
    int dato;
    Nodo siguiente;
    Nodo anterior;
    
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
