package AVLTree;

import Excepciones.isEmptyException;
import Node.Node;


public class AVLTree<T extends Comparable<T>> {

    private Node<T> root;
    private int size;

    public AVLTree(T value) {
        add(value);
    }

  
    public boolean add(T value) {
        if (value == null) {
            return false;
        }
        Node<T> node;
        try {
            if ((node = search(value)) != null) {
                node.setCont(node.getCont() + 1);
                size = size + 1;
                return true;
            }
        } catch (isEmptyException e) {
            System.err.println(e.getMessage());
            return false;
        }
        node = new Node<>(value);
        if (this.size == 0) {
            root = node;
            size = size + 1;
            findHtBf(root);
            return true;
        } else {
            add(root, node);
            size = size + 1;
            return true;
        }
    }

    private boolean add(Node<T> root, Node<T> node) {
        if (root == null) {
            return false;
        }

        T rootData = root.getValue();
        T nodeData = node.getValue();

        
        if (rootData.compareTo(nodeData) < 0) {
            if (root.getNext() == null) {
                root.setNext(node);
            } else {
                add(root.getNext(), node);
            }
        } else if (rootData.compareTo(nodeData) > 0) {
            if (root.getPrev() == null) {
                root.setPrev(node);
            } else {
                add(root.getPrev(), node);
            }
        }
        findHtBf(root);
        trinodeRotate(root);
        return true;
    }

    private void findHtBf(Node<T> node) {
        int lh = (node.getPrev() != null) ? node.getPrev().getHeight() : -1;
        int rh = (node.getNext() != null) ? node.getNext().getHeight() : -1;
        node.setHeight(Math.max(lh, rh) + 1);
        node.setBalanceFactor(lh - rh);
    }

    private void trinodeRotate(Node<T> node) {
        if (node.getBalanceFactor() > 1) {
            if (node.getPrev() != null) {
                if (node.getPrev().getBalanceFactor() >= 0) {
                    rightRotate(node);
                } else if (node.getPrev().getBalanceFactor() < 0) {
                    leftRightRotate(node);
                }
            }
        } else if (node.getBalanceFactor() < -1) {
            if (node.getNext() != null) {
                if (node.getNext().getBalanceFactor() > 0) {
                    rightLeftRotate(node);
                } else if (node.getNext().getBalanceFactor() <= 0) {
                    leftRotate(node);
                }
            }
        }
    }

    private void rightRotate(Node<T> node) {
        Node<T> newNode = new Node<>(node.getValue());
        Node<T> left = node.getPrev();

        newNode.setNext(node.getNext());
        newNode.setPrev(left.getNext());

        node.setNext(newNode);
        node.setValue(left.getValue());
        node.setPrev(left.getPrev());
        left.setPrev(null);

        findHtBfSub(node);

    }

    private void leftRotate(Node<T> node) {
        T origData = node.getValue();
        Node<T> right = node.getNext();
        Node<T> newNode = new Node<>(origData);

        newNode.setPrev(node.getPrev());
        newNode.setNext(right.getPrev());

        node.setPrev(newNode);
        node.setValue(right.getValue());
        node.setNext(right.getNext());
        right.setNext(null);

        findHtBfSub(node);
    }

    private void leftRightRotate(Node<T> node) {
        leftRotate(node.getPrev());
        rightRotate(node);
    }

    private void rightLeftRotate(Node<T> node) {
        rightRotate(node.getNext());
        leftRotate(node);
    }

    private void findHtBfSub(Node<T> root) {
        if (root.getPrev() != null) {
            findHtBfSub(root.getPrev());
        }
        if (root.getNext() != null) {
            findHtBfSub(root.getNext());
        }
        findHtBf(root);
    }

    private int cont;

    
    public int between(T start, T end) throws isEmptyException {
        cont = -1;
        between(root, start, end);
        return cont + 1;
    }

    private void between(Node<T> node, T x, T y) {
        if (node == null) {
            return;
        }
        if (node.getValue().compareTo(x) == 1) {
            between(node.getPrev(), x, y);
        }
        if ((node.getValue().compareTo(x) == 0 || node.getValue().compareTo(x) == 1) && (node.getValue().compareTo(y) == 0 || node.getValue().compareTo(y) == -1)) {
            if (node.getCont() > 0) {
                for (int i = 0; i < node.getCont() + 1; i++) {
                    cont = cont + 1;
                }
            } else {
                cont = cont + 1;
            }
        }
        if (node.getValue().compareTo(y) == -1) {
            between(node.getNext(), x, y);
        }
    }

    
    public T bigger() throws isEmptyException {
        return bigger(root);
    }

    private T bigger(Node<T> node) {
        return node.getNext() == null ? node.getValue() : bigger(node.getNext());
    }

    private int altura = 0;

    
    public int height() throws isEmptyException {
        heigth(root, 1);
        return altura;
    }

    private void heigth(Node<T> reco, int nivel) {
        if (reco != null) {
            heigth(reco.getPrev(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            heigth(reco.getNext(), nivel + 1);
        }
    }

    
    public void inOrder() throws isEmptyException {   
        inOrder(root);
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.getPrev());
            System.out.print(" " + node.getValue() + "{" + node.getLevel() + "," + node.getCont() + "}");
            inOrder(node.getNext());
        }
    }

    
    public void isEmpty() throws isEmptyException {
        if (root == null) {
            throw new isEmptyException("Empty tree.");
        }
    }

    
    public T minor() throws isEmptyException {
        return minor(root);
    }
    
    private T minor(Node<T> node) {
        if (node.getPrev()== null) {
            return node.getValue();
        } else {
            return minor(node.getPrev());
        }
    }

    
    public void postOrder() throws isEmptyException {
        postOrder(root);
    }

    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.getPrev());
            postOrder(node.getNext());
            System.out.print(" " + node.getValue() + "{" + node.getLevel() + "," + node.getCont() + "}");
        }
    }

    
    public void preOrder() throws isEmptyException {
        preOrder(root);       
    }

     private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(" " + node.getValue() + "{" + node.getLevel() + "," + node.getCont() + "}");
            preOrder(node.getPrev());
            preOrder(node.getNext());
        }
    }

    
    public boolean remove(T value) throws isEmptyException {
        if (value == null) {
            return false;
        }

        if (search(value) == null) {
            return false;
        }

        if (size == 1 && root.getValue().compareTo(value) == 0) {
            root = null;
            size = size - 1;
            return true;

        } else {
            root = remove(root, value);
        }
        size = size - 1;
        return true;
    }

    private Node<T> remove(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getValue()) == 0) {
            Node<T> replaceData = successor(node);
            if (replaceData.getCont() == 0) {
                if (node.getCont() > 0) {
                    node.setCont(node.getCont() - 1);
                } else {
                    if (node.getPrev() == null && node.getNext() == null) {
                        return null;
                    } else if (node.getPrev() == null) {
                        return node.getNext();
                    } else if (node.getNext() == null) {
                        return node.getPrev();
                    } else {
                        node.setValue(replaceData.getValue());
                        node.setCont(replaceData.getCont());
                        node.setHeight(replaceData.getHeight());
                        node.setNext(remove(node.getNext(), replaceData.getValue()));
                    }
                }
            } else {
                replaceData.setCont(replaceData.getCont() - 1);
            }
        } else if (data.compareTo(node.getValue()) < 0) {
            node.setPrev(remove(node.getPrev(), data));
        } else {
            node.setNext(remove(node.getNext(), data));
        }
        findHtBf(node);
        trinodeRotate(node);
        return node;
    }

    private Node<T> successor(Node<T> node) {
        if (node.getNext() != null) {
            node = node.getNext();
        }
        if (node == null) {
            return null;
        }
        Node<T> left = node.getPrev();
        if (left == null) {
            return node;
        } else {
            return successor(left);
        }
    }

    
    public Node<T> search(T value) throws isEmptyException {
        return search(value, root);
    }

    private Node<T> search(T value, Node<T> root) {
        if (root == null) {
            return null;
        } else {
            if (root.getValue().equals(value)) {
                return root;
            } else {
                return value.compareTo(root.getValue()) < 0 ? search(value, root.getPrev()) : search(value, root.getNext());
            }
        }
    }

    
    public String toString() {
        return TreePrinter.getTreeDisplay(root);
    }
}
