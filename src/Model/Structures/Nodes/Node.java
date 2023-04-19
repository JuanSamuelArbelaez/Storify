package Model.Structures.Nodes;

import java.io.Serializable;

public class Node<E extends Comparable<E>> implements Serializable {
    private E value = null;
    public Node(E value) {this.value = value;}
    public E getValue() {
        return value;
    }
    public void setValue(E value) {
        this.value = value;
    }
    public int compareTo(LinkedNode<E> other) {
        return this.getValue().compareTo(other.getValue());
    }
}
