package Model.Structures.DoubleLinkedList;


import Model.Structures.LinkedList.LinkedList;
import Model.Structures.LinkedList.LinkedList_Interface;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public interface DoubleLinked_Interface<E extends Comparable<E>> extends LinkedList_Interface<E>{
    int size();
    boolean isEmpty();
    boolean sorted();
    boolean contains(E data);
    Iterator iterator();
    void add(E data);
    void add(int index, E data);

    E poll();

    boolean addAll(LinkedList<E> list);
    void insert(E data);
    void remove(E data);
    void remove(int index);
    void clear();
    E get(int index);
    boolean validIndex(int index);
    E poll(int index);
    void push(E data);
    int indexOf(E data);
    int lastIndexOf(E data);
    void removeAll(Collection<?> c);
    void sort(Comparator<? super E> c);
    void removeAll(LinkedList<E> c);
}
