package Model.Structures.HashMap;

import Model.Structures.Nodes.HashNode;

public class HashMap<K, V extends Comparable<V>> implements HashMap_Interface<K,V>{
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private HashNode[] table;
    private int size;
    private int capacity;
    private float loadFactor;
    public HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }
    public HashMap(int initialCapacity, float loadFactor) {
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.table = new HashNode[capacity];
        this.size = 0;
    }
    @Override public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed");
        }
        int hash = hash(key);
        int index = hash % capacity;

        table[index] = putRecursive(table[index], key, value, hash);
        size++;

        if (size > capacity * loadFactor) {
            resize();
        }
    }
    private HashNode<K, V> putRecursive(HashNode<K, V> entry, K key, V value, int hash) {
        if (entry == null) {
            return new HashNode<>(key, value, hash, null);
        }
        if (entry.getHash() == hash && entry.getKey().equals(key)) {
            entry.setValue(value);
            return entry;
        }
        entry.setNext(putRecursive(entry.getNext(), key, value, hash));
        return entry;
    }
    @Override public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed");
        }
        int hash = hash(key);
        int index = hash % capacity;

        return (V) getRecursive(table[index], key, hash);
    }
    private V getRecursive(HashNode<K, V> entry, K key, int hash) {
        if (entry == null) {
            return null;
        }
        if (entry.getHash() == hash && entry.getKey().equals(key)) {
            return entry.getValue();
        }
        return getRecursive(entry.getNext(), key, hash);
    }
    @Override public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed");
        }
        int hash = hash(key);
        int index = hash % capacity;

        table[index] = removeRecursive(table[index], key, hash);
        size--;
    }
    private HashNode<K, V> removeRecursive(HashNode<K, V> entry, K key, int hash) {
        if (entry == null) {
            return null;
        }
        if (entry.getHash() == hash && entry.getKey().equals(key)) {
            return entry.getNext();
        }
        entry.setNext(removeRecursive(entry.getNext(), key, hash));
        return entry;
    }
    @Override public int hash(K key) {return key.hashCode() & 0x7FFFFFFF;}
    @Override public void resize() {
        int newCapacity = capacity * 2;
        HashNode<K, V>[] newTable = new HashNode[newCapacity];

        for (HashNode<K, V> hashNode : table) {
            HashNode<K, V> e = hashNode;
            while (e != null) {
                int newIndex = e.getHash() % newCapacity;
                HashNode<K, V> oldNext = e.getNext();
                e.setNext(newTable[newIndex]);
                newTable[newIndex] = e;
                e = oldNext;
            }
        }

        table = newTable;
        capacity = newCapacity;
    }
    @Override public boolean contains(V value) {
        for (HashNode<K, V> hashNode : table) {
            HashNode<K, V> node = hashNode;
            while (node != null) {
                if (node.getValue().equals(value)) {
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
}
    @Override public int getSize() {return size;}
    @Override public boolean containsKey(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        return containsKey(table[index], key, hash);
    }
    private boolean containsKey(HashNode<K, V> node, K key, int hash) {
        if (node == null) {
            return false;
        }
        if (node.getHash() == hash && node.getKey().equals(key)) {
            return true;
        }
        return containsKey(node.getNext(), key, hash);
    }
    private int indexFor(int hash, int tableSize) {
        return hash & (tableSize - 1);
    }
}
