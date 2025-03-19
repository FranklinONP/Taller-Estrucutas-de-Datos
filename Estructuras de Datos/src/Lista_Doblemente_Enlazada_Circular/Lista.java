package Lista_Doblemente_Enlazada_Circular;

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

        // Caso 1: La lista está vacía
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza; // Apunta a sí mismo (circular)
            cabeza.anterior = cabeza;  // Apunta a sí mismo (circular)
            return;
        }

        // Caso 2: La lista tiene al menos un nodo
        Nodo ultimo = cabeza.anterior; // El último nodo es el anterior a la cabeza en una lista circular

        // Conectar el nuevo nodo
        ultimo.siguiente = nuevoNodo;
        nuevoNodo.anterior = ultimo;
        nuevoNodo.siguiente = cabeza;
        cabeza.anterior = nuevoNodo;
    }

    // Método para buscar el nodo anterior a un valor dado
    public void printBefore(int value) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        boolean encontrado = false;

        // Recorrer la lista circular
        do {
            if (actual.dato == value) {
                if (actual == cabeza && actual.anterior == cabeza) {
                    System.out.println("El valor " + value + " es el único nodo, no tiene anterior.");
                } else {
                    System.out.println("El anterior a " + value + " es: " + actual.anterior.dato);
                }
                encontrado = true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (!encontrado) {
            System.out.println("El valor " + value + " no se encuentra en la lista.");
        }
    }

    // Método para imprimir la lista
    public void imprimir() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(vuelve a " + cabeza.dato + ")");
    }
}