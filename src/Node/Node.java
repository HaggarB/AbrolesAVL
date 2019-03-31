package Node;

public class Node<T extends Comparable<T>> {

    private T value;
    private Node<T> next;
    private Node<T> prev;
    private int cont;
    private int lvl = 1;
    private int bF;
    private int alt;
    
    public Node(T value, Node<T> next, Node<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
        alt = 0;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node() {
        this.value = null;
        this.next = null;
        this.prev = null;
    }

    public Node(T value) {
        this.value = value;

    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getLevel() {
        return lvl;
    }

    public void setLevel(int lvl) {
        this.lvl = lvl;
    }
    
    public String getText(){
        int nivel = (this.lvl + 1);
        return this.value.toString()+" {nivel: "+nivel+", repeticiones: "+this.cont+"}";
    }
    
     public int getHeight() {
        return alt;
    }

    public void setHeight(int height) {
        this.alt = height;
    }

    public int getBalanceFactor() {
        return bF;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.bF = balanceFactor;
    }

}

