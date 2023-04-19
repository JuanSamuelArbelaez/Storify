package Model.Structures.BinaryTree;

import java.io.Serializable;
import java.util.function.Consumer;

public interface BinaryTree_Interface<E extends Comparable<E>> extends Serializable {
    void add(E value);
    boolean contains(E value);
    void remove(E value);
    int size();
    boolean isEmpty();
    void clear();
    void preOrderTraversal(Consumer<E> consumer);
    void inOrderTraversal(Consumer<E> consumer);
    void postOrderTraversal(Consumer<E> consumer);
    int height();

    void balance();
}
