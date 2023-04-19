package Model.Structures.Nodes;

public class DoubleLinkedNode<E extends Comparable<E>> extends Node<E> {
    private DoubleLinkedNode<E> previous = null;
    private DoubleLinkedNode<E> next = null;
    public DoubleLinkedNode(E value) {
        super(value);}
    public DoubleLinkedNode(E value, DoubleLinkedNode<E> next){
        super(value);
        this.next=next;
    }
    public DoubleLinkedNode(E value, DoubleLinkedNode<E> next, DoubleLinkedNode<E> previous){
        super(value);
        this.next=next;
        this.previous = previous;
    }
    public DoubleLinkedNode<E> getNext() {
        return next;
    }
    public void setNext(DoubleLinkedNode<E> next) {this.next = next;}
    public DoubleLinkedNode<E> getPrevious() {
        return previous;
    }
    public void setPrevious(DoubleLinkedNode<E> previous) {
        this.previous = previous;
    }
}
