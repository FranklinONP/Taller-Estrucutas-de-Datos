/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista_Simplemente_Enlazada;

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
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevoNodo;
    }
    
    // Método para eliminar un nodo con un valor específico
    public void eliminar(int dato) {
        if (cabeza == null) {
            return; // Lista vacía, no hay nada que eliminar
        }
        
        // Caso especial: eliminar el primer nodo
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return;
        }
        
        Nodo actual = cabeza;
        Nodo anterior = null;
        
        // Buscar el nodo a eliminar
        while (actual != null && actual.dato != dato) {
            anterior = actual;
            actual = actual.siguiente;
        }
        
        // Si encontramos el nodo, eliminarlo
        if (actual != null) {
            anterior.siguiente = actual.siguiente;
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
    
    public void graficar(String directorio) {
        try {
            // Crear el archivo .dot
            FileWriter writer = new FileWriter(directorio + ".dot");
            writer.write("digraph lista_simple {\n");
            writer.write("    rankdir=LR;\n"); // Dirección de izquierda a derecha
            writer.write("    node [shape=record];\n");
            
            // Generar los nodos y conexiones
            Nodo actual = cabeza;
            int contador = 0;
            String nodos = "";
            String conexiones = "";
   
            
            // Crear nodos
            while (actual != null) {
                nodos += "    nodo" + contador + " [label=\"{ " + actual.dato + " | <sig>}\"];\n";
                if (actual.siguiente != null) {
                    conexiones += "    nodo" + contador + ":sig -> nodo" + (contador + 1) + ";\n";
                }

                actual = actual.siguiente;
                contador++;
            }
            
            // Combinar todo
            writer.write(nodos);
            writer.write(conexiones);
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