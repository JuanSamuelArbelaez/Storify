package Model.Structures.Nodes;

public class LinkedNode<E extends Comparable<E>> extends Node<E> {
    private LinkedNode<E> next = null;
    public LinkedNode(E value) {
        super(value);}
    public LinkedNode(E value, LinkedNode<E> next){
        super(value);
        this.next = next;
    }
    public LinkedNode<E> getNext() {
        return next;
    }
    public void setNext(LinkedNode<E> next) {this.next = next;}
}
