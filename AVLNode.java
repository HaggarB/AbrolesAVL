/*
 * Basic node stored in AVL trees
 */


/**
 *
 * @author fires
 * blog: http://proyectosbeta.blogspot.com/
 */
public class AVLNode {
    public Comparable dato;      	 // el dato del nodo
    public AVLNode izquierdo;            // hijo izquierdo
    public AVLNode derecho;              // hijo derecho
    public int height;                   // altura

    // Constructors
    public AVLNode( Comparable dato ){
        this( dato, null, null );
    }

    public AVLNode( Comparable dato, AVLNode izq, AVLNode der ){
        this.dato = dato;
        this.izquierdo = izq;
        this.derecho = der;
        height   = 0;               // altura predeterminada
    }
}