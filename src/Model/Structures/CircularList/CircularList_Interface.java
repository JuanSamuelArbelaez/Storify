package Model.Structures.CircularList;

import java.io.Serializable;

public interface CircularList_Interface<E> extends Serializable, Iterable<E> {
    int indexOf(E data);
    int size();
}
