package Model.Structures.Queue;

import Model.Structures.LinkedList.LinkedList;
import Model.Structures.Nodes.LinkedNode;

public class Queue<E extends Comparable<E>> extends LinkedList<E> {

    @Override protected void addRecursive(int index, LinkedNode<E> current, E data){
        Queue<E> queueAux = new Queue<E>();
        if(index==0) queueAux.add(data);
        if(current.getNext() != null){
            queueAux.add(current.getNext().getValue());
            addRecursive(index-1, current.getNext(), data);
        }
        clear();
        addAll(queueAux);
    }
    public void queue(E data){
        add(data);
    }
    public void deQueue(E data){
        remove(data);
    }
}
