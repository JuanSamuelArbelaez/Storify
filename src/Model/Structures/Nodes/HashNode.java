package Model.Structures.Nodes;

public class HashNode<K, V extends Comparable <V>> extends Node<V>{
    private final K key;
    private int hash = 0;
    private HashNode<K, V> next;
    public HashNode(K key, V value, HashNode<K,V> next) {
        super(value);
        this.key = key;
        this.hash = key.hashCode();
        this.next = next;
    }
    public HashNode(K key, V value) {
        super(value);
        this.key = key;
        this.hash = key.hashCode();
    }
    public HashNode(K key, V value, int hash, HashNode<K, V> next) {
        super(value);
        this.key = key;
        this.hash = hash;
        this.next = next;
    }

    public K getKey() {return key;}
    public int getHash() {return hash;}
    public HashNode<K, V> getNext() {return next;}
    public void setNext(HashNode<K, V> next) {this.next = next;}
}
