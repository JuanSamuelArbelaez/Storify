package Model.Structures.LinkedList;

import Model.Structures.Nodes.LinkedNode;
import java.util.*;

public class LinkedList<E extends Comparable<E>> implements LinkedList_Interface<E> {
    private boolean sorted= false;
    private final LinkedNode<E> head;
    private int size;
    public LinkedList() {
        head = new LinkedNode<E>(null);
        size = 0;
    }
    public LinkedList(LinkedList<E> c) {
        head = new LinkedNode<E>(null);
        size = 0;
        addAll(c);
    }
    @Override public int size() {return size;}
    @Override public boolean isEmpty() {return size == 0;}
    @Override public boolean sorted() {return this.sorted;}
    @Override public boolean contains(E data) {return containsRecursive(this.head.getNext(), data);}
    public boolean containsRecursive(LinkedNode<E> current, E data) {
        if (current == null) return false;
        if (Objects.equals(current.getValue(), data)) return true;
        return containsRecursive(current.getNext(), data);
    }
    @Override public Iterator<E> iterator() {
        return new Iterator<E>() {
            LinkedNode<E> current = head.getNext();
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
        };
    }
    @Override public void add(E data) {add(size, data);}
    @Override public void add(int index, E data) throws IndexOutOfBoundsException {
        if(index<0 && index > size) throw new IndexOutOfBoundsException("Index out of bounds");
        addRecursive(index, head, data);
        size++;
        sorted=false;
    }
    protected void addRecursive(int index, LinkedNode<E> current, E data)  {
        if (index == 0) current.setNext(new LinkedNode<E>(data, current.getNext()));
        else {
            addRecursive(index - 1, current.getNext(), data);
        }
    }
    @Override public void insert(E data) {
        if(!sorted) throw new UnsupportedOperationException("Structure unsorted. Sort before inserting");
        insertRecursive(head, data);
        size++;
    }
    protected void insertRecursive(LinkedNode<E> current, E value) {
        if (current.getNext() == null) {
            current.setNext(new LinkedNode<>(value));
        }
        else if (value.compareTo(current.getNext().getValue()) <= 0) {
            current.setNext(new LinkedNode<E>(value, current.getNext()));
        }
        else insertRecursive(current.getNext(), value);
    }
    @Override public boolean addAll(LinkedList<E> c) {
        if (c.isEmpty()) {
            return false;
        } else {
            Iterator<? extends E> it = c.iterator();
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
        sorted=false;
        head.setNext(null);
        size=0;
    }
    @Override public E get(int index) throws IndexOutOfBoundsException {
        if(!validIndex(index)) throw new IndexOutOfBoundsException("Item index out of bounds");
        else return getRecursive(head.getNext(), index);
    }
    private E getRecursive(LinkedNode<E> current, int index) {
        if(index==0) return current.getValue();
        else return getRecursive(current.getNext(), index-1);
    }
    @Override public boolean validIndex(int index) {return (index>=0 && index<size);}
    @Override public void remove(E data){
         removeRecursive(head, data);
    }
    public void removeRecursive(LinkedNode<E> current, E data) throws NullPointerException {
        if (current.getNext() == null) throw new NullPointerException("Item not found");
        else if (!Objects.equals(current.getNext().getValue(), data)) removeRecursive(current.getNext(), data);
        else {
            current.setNext(current.getNext().getNext());
            size--;
        }
    }
    @Override public void remove(int index) throws IndexOutOfBoundsException {
        if(!validIndex(index)) throw new IndexOutOfBoundsException("Item index out of bounds");
        else removeRecursive(head, index);
    }
    private void removeRecursive(LinkedNode<E> current, int index) {
        if (index != 0) removeRecursive(current.getNext(), index - 1);
        else {
            current.setNext(current.getNext().getNext());
            size--;
        }
    }
    @Override public E poll(int index) throws IndexOutOfBoundsException {
        if(!validIndex(index)) throw new IndexOutOfBoundsException("Item index out of bounds");
        else return pollRecursive(head, index);
    }
    @Override public E poll() {
        if(!validIndex(0)) throw new IndexOutOfBoundsException("Item index out of bounds");
        else return pollRecursive(head, 0);
    }
    private E pollRecursive(LinkedNode<E> current, int index) {
        if (index != 0) return pollRecursive(current.getNext(), index - 1);
        else {
            E data = current.getNext().getValue();
            current.setNext(current.getNext().getNext());
            size--;
            return data;
        }
    }
    @Override public void push(E data){
        add(0, data);
    }
    @Override public int indexOf(E data) {
        return indexOfRecursive(head.getNext(), data, 0);
    }
    private int indexOfRecursive(LinkedNode<E> current, E data, int index) {
        if (current == null) return -1;
        else if (Objects.equals(current.getValue(), data)) return index;
        else return indexOfRecursive(current.getNext(), data, index + 1);
    }
    @Override public int lastIndexOf(E data) {
        return lastIndexOfRecursive(head.getNext(), data, -1);
    }
    private int lastIndexOfRecursive(LinkedNode<E> current, E data, int lastIndex) {
        if (current == null) {
            return lastIndex;
        } else if (Objects.equals(current.getValue(), data)) {
            lastIndex = lastIndexOfRecursive(current.getNext(), data, lastIndex + 1);
        } else {
            lastIndex = lastIndexOfRecursive(current.getNext(), data, lastIndex);
        }
        return lastIndex;
    }
    @Override public LinkedList subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) throw new IndexOutOfBoundsException();
        if (fromIndex == 0 && toIndex == size) return this;
        return subListRecursive(head.getNext().getNext(), fromIndex, toIndex, 0, new LinkedList<>());
    }
    private LinkedList<E> subListRecursive(LinkedNode<E> current, int fromIndex, int toIndex, int currentIndex, LinkedList<E> subList) {
        if (current == null) return subList;
        if (currentIndex >= fromIndex && currentIndex < toIndex)  subList.add(current.getValue());
        return subListRecursive(current.getNext(), fromIndex, toIndex, currentIndex + 1, subList);
    }
    @Override public void removeAll(Collection<?> c) {
        if (c == null) throw new NullPointerException();
        else head.setNext(removeAllRecursive(head.getNext(), c));
    }
    private LinkedNode<E> removeAllRecursive(LinkedNode<E> current, Collection<?> c) {
        if (current == null) return null;
        else if (c.contains(current.getValue())) return removeAllRecursive(current.getNext(), c);
        else {
            current.setNext(removeAllRecursive(current.getNext(), c));
            return current;
        }
    }
    @Override public void sort(Comparator<? super E> c){
        if(isEmpty()) return;
        head.setNext(mergeSort(head.getNext(), c));
        sorted=true;
    }
    public void sort(){
        if(isEmpty()) return;
        sortRecursive(head);
        sorted=true;
    }
    private void sortRecursive(LinkedNode<E> current){
        if(current.getNext()!=null) {
            LinkedNode<E> next = current.getNext();
            LinkedNode<E> follow = next.getNext();
            if(next.getValue().compareTo(follow.getValue())>0){
                next.setNext(follow.getNext());
                follow.setNext(next);
                current.setNext(follow);
            }
        }

    }
    private LinkedNode<E> mergeSort(LinkedNode<E> current, Comparator<? super E> comparator) {
        if(current == null ||current.getNext() == null) return current;
        LinkedNode<E> middle = findMiddleRecursive(current);
        LinkedNode<E> secondHalf = middle.getNext();

        middle.setNext(null);

        LinkedNode<E> left = mergeSort(current, comparator);
        LinkedNode<E> right = mergeSort(secondHalf, comparator);

        return merge(left, right);

    }
    private LinkedNode<E> findMiddleRecursive(LinkedNode<E> start){
        LinkedNode<E> slow = start;
        LinkedNode<E> fast = start.getNext();
        if(fast != null && fast.getNext() != null) slow = findMiddleRecursive(slow.getNext());
        return slow;
    }
    private LinkedNode<E> merge(LinkedNode<E> left, LinkedNode<E> right){
        if(left == null) return right;
        if(right == null) return left;
        if(left.getValue().compareTo(right.getValue())<1) {
            left.setNext(merge(left.getNext(), right));
            return left;
        } else {
            right.setNext(merge(left, right.getNext()));
            return right;
        }
    }
    public LinkedList<E> appendList(LinkedList<E> left, LinkedList<E> right){
        LinkedList<E> aux = new LinkedList<E>();
        Iterator<E> it = left.iterator();
        for(; it.hasNext();){
            aux.add(it.next());
        }
        it = right.iterator();
        for(; it.hasNext();){
            aux.add(it.next());
        }
        return aux;
    }

}
