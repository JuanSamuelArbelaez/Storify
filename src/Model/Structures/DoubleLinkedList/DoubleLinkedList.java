package Model.Structures.DoubleLinkedList;

import Model.Structures.LinkedList.LinkedList;
import Model.Structures.Nodes.DoubleLinkedNode;

import java.util.*;

public class DoubleLinkedList <E extends Comparable<E>> implements DoubleLinked_Interface<E> {
    private boolean sorted= false;
    private final DoubleLinkedNode<E> head;
    private final DoubleLinkedNode<E> tail;
    private int size;
    public DoubleLinkedList() {
        head = new DoubleLinkedNode<>(null);
        tail = new DoubleLinkedNode<>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }
    @Override public int size() {return size;}
    @Override public boolean isEmpty() {return size==0;}
    @Override public boolean sorted(){return this.sorted;}
    @Override public boolean contains(E data) {
        return containsRecursive(this.head.getNext(), data);}
    public boolean containsRecursive(DoubleLinkedNode<E> current, E data) {
        if (current == null) return false;
        if (Objects.equals(current.getValue(), data)) return true;
        return containsRecursive(current.getNext(), data);
    }
    @Override public Iterator<E> iterator() {
        return new Iterator<E>() {
            DoubleLinkedNode<E> current = head.getNext();
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.getValue();
                current = current.getNext();
                return data;
            }
            public boolean hasPrevious() {
                return current != null && current.getPrevious() != null;
            }
            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                current = current.getPrevious();
                return current.getValue();
            }
        };
    }
    @Override public void add(E data) {add(size, data);}
    @Override public void add(int index, E data) throws IndexOutOfBoundsException {
        if(index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");
        addRecursive(index, head, data);
        size++;
        sorted=false;
    }
    public void addRecursive(int index, DoubleLinkedNode<E> current, E data)  {
        if (index == 0) {
            DoubleLinkedNode<E> aux = new DoubleLinkedNode<>(data, current.getNext(), current);
            current.setNext(aux);
            aux.getNext().setPrevious(aux);
        }
        else addRecursive(index - 1, current.getNext(), data);
    }
    @Override public void insert(E data) {
        if(!sorted) throw new UnsupportedOperationException("Structure unsorted. Sort before inserting");
        insertRecursive(head, data);
        size++;
    }
    private void insertRecursive(DoubleLinkedNode<E> current, E value) {
        if (current.getNext() == tail) {
            current.setNext(new DoubleLinkedNode<>(value, tail, current));
            tail.setNext(current.getNext());
        }
        else if (value.compareTo(current.getNext().getValue()) <= 0) {
            DoubleLinkedNode<E> aux = new DoubleLinkedNode<>(value, current.getNext());
            current.setNext(aux);
            aux.getNext().setPrevious(aux);
        }
        else insertRecursive(current.getNext(), value);
    }
    @Override public void remove(E data){removeRecursive(head, data);}
    public void removeRecursive(DoubleLinkedNode<E> current, E data) throws NullPointerException {
        if (current.getNext() == tail) throw new NullPointerException("Item not found");
        else if (!current.getNext().getValue().equals(data)) removeRecursive(current.getNext(), data);
        else {
            DoubleLinkedNode<E> aux = current.getNext().getNext();
            aux.setPrevious(current);
            current.setNext(aux);
            size--;
        }
    }
    @Override public void remove(int index)  throws IndexOutOfBoundsException {
        if(!validIndex(index)) throw new IndexOutOfBoundsException("Item index out of bounds");
        else removeRecursive(head, index);
    }
    private void removeRecursive(DoubleLinkedNode<E> current, int index) {
        if (index != 0) removeRecursive(current.getNext(), index - 1);
        else {
            current.setNext(current.getNext().getNext());
            current.getNext().setPrevious(current);
            size--;
        }
    }
    @Override public E poll(int index) {
        if(!validIndex(index)) throw new IndexOutOfBoundsException("Item index out of bounds");
        else return pollRecursive(head, index);
    }
    @Override public E poll() {
        if(!validIndex(0)) throw new IndexOutOfBoundsException("Item index out of bounds");
        else return pollRecursive(head, 0);
    }
    private E pollRecursive(DoubleLinkedNode<E> current, int index) {
        if (index != 0) return pollRecursive(current.getNext(), index - 1);
        else {
            E data = current.getNext().getValue();
            current.setNext(current.getNext().getNext());
            current.getNext().setPrevious(current);
            size--;
            return data;
        }
    }
    @Override public boolean addAll(LinkedList<E> list) {
        if (list.isEmpty()) {
            return false;
        } else {
            Iterator<? extends E> it = list.iterator();
            addAllRecursive(it);
            return true;
        }
    }
    private void addAllRecursive(Iterator<? extends E> it) {
        if (it.hasNext()) {
            add(it.next());
            addAllRecursive(it);
        }
    }
    @Override public void clear() {
        this.head.setNext(tail);
        this.tail.setPrevious(head);
        size=0;
    }
    @Override public E get(int index) throws IndexOutOfBoundsException {
        if(!validIndex(index)) throw new IndexOutOfBoundsException("Item index out of bounds");
        else return getRecursive(head.getNext(), index);
    }
    private E getRecursive(DoubleLinkedNode<E> current, int index) {
        if(index==0) return current.getValue();
        else return getRecursive(current.getNext(), index-1);
    }
    @Override public boolean validIndex(int index) {return (index>=0 && index<size);}
    @Override
    public void push(E data) {

    }
    @Override
    public int indexOf(E data) {
        return 0;
    }
    @Override
    public int lastIndexOf(E data) {
        return 0;
    }
    @Override
    public LinkedList<E> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAll(Collection<?> c) {
    }
    @Override
    public void sort(Comparator c) {
    }
    @Override
    public void removeAll(LinkedList<E> c) {
    }
}
