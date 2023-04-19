package Model.Structures.HashMap;

import java.io.Serializable;

public interface HashMap_Interface<K, V> extends Serializable{
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    int hash(K key);
    void resize();

    boolean contains(V value);

    int getSize();

    boolean containsKey(K key);
}
