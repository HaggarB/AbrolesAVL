package Main;
import Excepciones.isEmptyException;
import AVLTree.*;

public class Main {

    public static void main(String[] args) throws isEmptyException{
        
        AVLTree<Integer> arbol = new AVLTree<>(5);
        
        long tiemini, tiempo;
        
        arbol.add(3);
        arbol.add(5);
        arbol.add(7);
        arbol.add(9);
        arbol.add(41);
        arbol.add(134);
        
        //arbol.remove(5);
        //arbol.remove(41);
        
        System.out.println(arbol);
        System.out.println("");
        
        
        tiemini = System.nanoTime();
        arbol.add(9);
        tiempo = System.nanoTime() - tiemini;
        System.out.println("Duración del add: " + tiempo/1e6 + " ms");
        
        tiemini = System.nanoTime();
        arbol.search(11);
        tiempo = System.nanoTime() - tiemini;
        System.out.println("\nDuración del search: " + tiempo/1e6 + " ms");
        
        tiemini = System.nanoTime();
        arbol.remove(11);
        tiempo = System.nanoTime() - tiemini;
        System.out.println("\nDuración del remove: " + tiempo/1e6 + " ms");
        
        tiemini = System.nanoTime();
        arbol.inOrder();
        tiempo = System.nanoTime() - tiemini;
        System.out.println("\nDuración del inOrder: " + tiempo/1e6 + " ms");
        
        tiemini = System.nanoTime();
        arbol.postOrder();
        tiempo = System.nanoTime() - tiemini;
        System.out.println("\nDuración del postOrder: " + tiempo/1e6 + " ms");
        
        tiemini = System.nanoTime();
        arbol.preOrder();
        tiempo = System.nanoTime() - tiemini;
        System.out.println("\nDuración del preOrder: " + tiempo/1e6 + " ms");
        
        tiemini = System.nanoTime();
        System.out.println(arbol.between(3, 20));
        tiempo = System.nanoTime() - tiemini;
        System.out.println("\nDuración del between: " + tiempo/1e6 + " ms");
        
        tiemini = System.nanoTime();
        System.out.println(arbol.bigger());
        tiempo = System.nanoTime() - tiemini;
        System.out.println("\nDuración del bigger: " + tiempo/1e6 + " ms");
        
        tiemini = System.nanoTime();
        System.out.println(arbol.bigger());
        tiempo = System.nanoTime() - tiemini;
        System.out.println("\nDuración del minor: " + tiempo/1e6 + " ms");
        
        
        
    }
    
}

