package Libraries.Arrays.Lists;

import java.util.Iterator;

/**
 * @author javiersolanop
 * @param <T> Tipo de elemento
 */
public class ListIterator<T> implements Iterator<T>{

    Node<T> atrLink;

    public ListIterator(Node<T> prmLink)
    {
        atrLink = prmLink;
    }

    @Override
    public boolean hasNext() {
        return atrLink != null;  
    }

    @Override
    public T next() {
        T varValue = atrLink.getValue();
        atrLink = atrLink.getNext();
        return varValue;
    }
}
