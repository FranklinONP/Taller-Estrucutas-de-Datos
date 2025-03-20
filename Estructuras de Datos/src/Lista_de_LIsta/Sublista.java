/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista_de_LIsta;

/**
 *
 * @author 50232
 */
public class Sublista {
    NodoSublista cabeza;

    public Sublista() {
        this.cabeza = null;
    }

    public void agregar(int dato) {
        NodoSublista nuevoNodo = new NodoSublista(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoSublista ultimo = cabeza.anterior;

            ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimo;

            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
        }
    }

    public void imprimir() {
        if (cabeza == null) {
            System.out.println("Sublista vacía.");
            return;
        }

        NodoSublista actual = cabeza;
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("(circular)");
    }
}