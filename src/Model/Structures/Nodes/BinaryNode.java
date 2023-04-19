package Model.Structures.Nodes;

public class BinaryNode<E extends Comparable<E>> extends Node<E>{
    private BinaryNode<E> left = null;
    private BinaryNode<E> right = null;
    public BinaryNode(E value) {
        super(value);}
    public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right){
        super(value);
        this.left = left;
        this.right = right;
    }
    public BinaryNode<E> getLeft() {
        return left;
    }
    public void setLeft(BinaryNode<E> left) {this.left = left;}
    public BinaryNode<E> getRight() {
        return right;
    }
    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }
    public int compareTo(BinaryNode<E> other) {
        return this.getValue().compareTo(other.getValue());
    }
}
