/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista_de_LIsta;

/**
 *
 * @author 50232
 */
public class ListaDeListas {
    NodoListaPrincipal cabeza;

    public ListaDeListas() {
        this.cabeza = null;
    }

      public void agregarSublista(int indice) {
        NodoListaPrincipal nuevoNodo = new NodoListaPrincipal();

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
            cabeza.indice=indice;
        } else {
            NodoListaPrincipal ultimo = cabeza.anterior;

            ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimo;

            nuevoNodo.siguiente = cabeza;
            nuevoNodo.indice=indice;
            cabeza.anterior = nuevoNodo;
        }
    }

    public void agregarElementoASublista(int indiceSublista, int dato) {
        if (cabeza == null) {
            System.out.println("No hay sublistas creadas.");
            return;
        }

        NodoListaPrincipal actual = cabeza;
        do {
            if (actual.indice == indiceSublista) {
                actual.sublista.agregar(dato);
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("Índice de sublista fuera de rango.");
    }

    public void imprimir() {
        if (cabeza == null) {
            System.out.println("Lista de listas vacía.");
            return;
        }

        NodoListaPrincipal actual = cabeza;

        do {
            System.out.print("Sublista " + actual.indice + ": ");
            actual.sublista.imprimir();
            actual = actual.siguiente;
    
        } while (actual != cabeza);
    }
    
    public void printByID(int indice) {
        if (cabeza == null) {
            System.out.println("Lista de listas vacía.");
            return;
        }

        NodoListaPrincipal actual = cabeza;
        do {
            if(indice==actual.indice){
                System.out.print("Sublista " + actual.indice + ": ");
                actual.sublista.imprimir();
            }
             actual = actual.siguiente;
        } while (actual != cabeza);
    }
}
