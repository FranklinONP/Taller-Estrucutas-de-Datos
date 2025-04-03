/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista_Doblemente_Enlazada;

import java.io.FileWriter;
import java.io.IOException;

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
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
            return;
        }
        
        Nodo actual = cabeza;
        Nodo current = cabeza;
        while (actual.siguiente != null) {
            current = actual;
            actual = actual.siguiente;
            actual.anterior = current;
        }
        actual.siguiente = nuevoNodo;
        nuevoNodo.anterior = actual; // Corrección: añadir enlace anterior al nuevo nodo
    }
    
    public void printBefore(int value){
        Nodo actual = cabeza;
        while (actual != null){
            if (actual.dato == value){
                if (actual.anterior != null) {
                    System.out.println("El anterior a " + value + " es: " + actual.anterior.dato);
                } else {
                    System.out.println("No hay nodo anterior a " + value);
                }
            }
            actual = actual.siguiente;
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
    
    
    /**
 * Método para eliminar un nodo con un valor específico de la lista
 * @param dato El valor del nodo que se desea eliminar
 */
public void eliminar(int dato) {
    // Caso 1: Lista vacía
    if (cabeza == null) {
        return;
    }

    Nodo actual = cabeza;

    // Caso 2: Eliminar el primer nodo (cabeza)
    if (actual.dato == dato) {
        cabeza = actual.siguiente;
        if (cabeza != null) {
            cabeza.anterior = null; // Actualizar el anterior de la nueva cabeza
        }
        return;
    }

    // Buscar el nodo a eliminar
    while (actual != null && actual.dato != dato) {
        actual = actual.siguiente;
    }

    // Caso 3: Nodo no encontrado
    if (actual == null) {
        return;
    }

    // Caso 4: Nodo encontrado en medio o al final
    if (actual.anterior != null) {
        actual.anterior.siguiente = actual.siguiente;
    }
    if (actual.siguiente != null) {
        actual.siguiente.anterior = actual.anterior;
    }
}
    
    // Nuevo método para graficar con Graphviz
    public void graficar(String directorio) {
        try {
            // Crear el archivo .dot
            FileWriter writer = new FileWriter(directorio + ".dot");
            writer.write("digraph Lista_Doble {\n");
            writer.write("    rankdir=LR;\n"); // Dirección de izquierda a derecha
            writer.write("    node [shape=record];\n");
            
            // Generar los nodos y conexiones
            Nodo actual = cabeza;
            int contador = 0;
            String nodos = "";
            String conexiones = "";
            String conexionesAtras = "";
            
            // Crear nodos
            while (actual != null) {
                nodos += "    nodo" + contador + " [label=\"{<ant> | " + actual.dato + " | <sig>}\"];\n";
                if (actual.siguiente != null) {
                    conexiones += "    nodo" + contador + ":sig -> nodo" + (contador + 1) + ":ant;\n";
                }
                if (actual.anterior != null) {
                    conexionesAtras += "    nodo" + contador + ":ant -> nodo" + (contador - 1) + ":sig [color=blue];\n";
                }
                actual = actual.siguiente;
                contador++;
            }
            
            // Combinar todo
            writer.write(nodos);
            writer.write(conexiones);
            writer.write(conexionesAtras);
            writer.write("}\n");
            writer.close();
            
            // Generar la imagen usando el comando dot
            String comando = "dot -Tpng " + directorio + ".dot -o " + directorio + ".png";
            Process proceso = Runtime.getRuntime().exec(comando);
            proceso.waitFor(); // Esperar a que se complete la generación
            
            System.out.println("Gráfico generado en: " + directorio + ".png");
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al generar el gráfico: " + e.getMessage());
        }
    }
}
