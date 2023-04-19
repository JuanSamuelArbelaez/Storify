package Model.Structures.CircularList;

import Model.Structures.DoubleLinkedList.DoubleLinkedList;
import Model.Structures.LinkedList.LinkedList;
import Model.Structures.Nodes.LinkedNode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CircularList <E extends Comparable<E>> implements CircularList_Interface<E>{
    public CircularList(LinkedList<E> list){
        addAll(list);
    }
    public CircularList(DoubleLinkedList<E> list){
        addAll(list);
    }
    public CircularList(){}
    private LinkedNode<E> head = new LinkedNode<>(null, null);
    private int size = 0;
    private boolean sorted = false;
    public boolean isEmpty() {return size == 0;}
    public void add(E data){
        add(size, data);
    }
    public void add(int index, E data){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");
        if(head.getNext() != null) addRecursive(index, head, data);
        else{
            head.setNext(new LinkedNode<>(data));
            head.getNext().setNext(head.getNext());
        }
        size++;
        sorted=false;
    }
    private void addRecursive(int index, LinkedNode<E> current, E data)  {
        if (index == 0) current.setNext(new LinkedNode<E>(data, current.getNext()));
        else {
            addRecursive(index - 1, current.getNext(), data);
        }
    }
    public void insert(E data) {
        if(!sorted) throw new UnsupportedOperationException("Structure unsorted. Sort before inserting");
        insertRecursive(head, data, size);
    }
    public void addAll(DoubleLinkedList<E> list) {
        addAll(list, 0);
    }
    public void addAll(LinkedList<E> list){
        addAll(list, 0);
    }
    private void addAll(LinkedList<E> list, int index){
        if(!list.validIndex(index)) return ;
        add(list.get(index));
        addAll(list, index+1);
    }
    private void addAll(DoubleLinkedList<E> list, int index){
        if(!list.validIndex(index)) return ;
        add(list.get(index));
        addAll(list, index+1);
    }
    private void insertRecursive(LinkedNode<E> current, E value, int index) {
        if (value.compareTo(current.getNext().getValue()) <= 0) {
            current.setNext(new LinkedNode<E>(value, current.getNext()));
            size++;
        }
        else if(index <= 0) add(value);
        else insertRecursive(current.getNext(), value, index-1);
    }
    public E get(int index) throws IndexOutOfBoundsException {
        if(!validIndex(index)) throw new IndexOutOfBoundsException("Item index out of bounds");
        else return getRecursive(head.getNext(), index);
    }
    private E getRecursive(LinkedNode<E> current, int index) {
        if(index==0) return current.getValue();
        else return getRecursive(current.getNext(), index-1);
    }
    public boolean validIndex(int index) {
        return (index>=0 && index<size);
    }
    public void sort(){
        if(size == 0 || size == 1) return;
        sortRecursive(head.getNext());
        //head.setNext(mergeSort(head.getNext()));
        sorted=true;
    }
    private void sortRecursive(LinkedNode<E> current){
        if(!current.getNext().equals(head.getNext())){
            LinkedNode<E> next = current.getNext();
            LinkedNode<E> follow = next.getNext();
            if(next.getValue().compareTo(follow.getValue())>0){
                next.setNext(follow.getNext());
                follow.setNext(next);
                current.setNext(follow);
            }
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            @Override
            public boolean hasNext() {
                return current != head.getNext();
            }

            @Override
            public E next() {
                if(!hasNext()) throw new NoSuchElementException();
                E data = current.getValue();
                return data;
            }

            LinkedNode<E> current = head.getNext();

        };
    }
    @Override public int indexOf(E data) {
        return indexOfRecursive(head.getNext(), data, 0);
    }

    @Override public int size() {
        return size;
    }

    private int indexOfRecursive(LinkedNode<E> current, E data, int index) {
        if(!validIndex(index) || current == null) return -1;
        else if (Objects.equals(current.getValue(), data)) return index;
        else return indexOfRecursive(current.getNext(), data, index + 1);
    }
}
