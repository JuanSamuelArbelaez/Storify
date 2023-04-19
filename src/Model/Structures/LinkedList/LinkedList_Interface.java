package Model.Structures.LinkedList;


import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public interface LinkedList_Interface<E extends Comparable<E>> extends Serializable, Iterable<E> {
    int size();
    boolean isEmpty();
    boolean sorted();
    boolean contains(E data);
    Iterator iterator();
    void add(E data);
    void add(int index, E data) throws IndexOutOfBoundsException;
    void insert(E data);
    void remove(E data);
    void remove(int index) throws IndexOutOfBoundsException;
    boolean addAll(LinkedList<E> c);
    void clear();
    E get(int index) throws IndexOutOfBoundsException;
    boolean validIndex(int index);
    E poll(int index) throws IndexOutOfBoundsException;
    E poll();
    void push(E data);
    int indexOf(E data);
    int lastIndexOf(E data);
    LinkedList<E> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException;
    void removeAll(Collection<?> c);
    void sort(Comparator<? super E> c);
}
