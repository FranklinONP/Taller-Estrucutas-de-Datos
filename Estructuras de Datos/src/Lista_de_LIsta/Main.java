        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista_de_LIsta;

/**
 *
 * @author 50232
 */
public class Main{
    public static void main(String[] args) {
        ListaDeListas lista = new ListaDeListas();

        // Agregamos 3 sublistas
        lista.agregarSublista(25);
        lista.agregarSublista(2);
        lista.agregarSublista(1);
        lista.agregarSublista(0);
        

        // Agregamos elementos a las sublistas
        lista.agregarElementoASublista(0, 10);
        lista.agregarElementoASublista(0, 20);
        
        
        lista.agregarElementoASublista(1, 30);
        lista.agregarElementoASublista(1, 40);
        
        lista.agregarElementoASublista(2, 50);
        lista.agregarElementoASublista(2, 60);
        
        lista.agregarElementoASublista(0,100);
        lista.agregarElementoASublista(0,1050);
        
        lista.agregarElementoASublista(25,100);
        
        
        // Imprimir la estructura
        lista.imprimir();
        
        System.out.println("============");
        lista.printByID(2);
    }
}
