 package Libraries.Arrays.Lists;

/**
 * @author javiersolanop
 * @param <T> Tipo de elemento
 */
public class Node<T> {
    
    private Node<T> atrPrevious;
    private Node<T> atrNext;
    private T atrValue;

    public Node()
    {
        atrNext = null;
        atrValue = null;
    }

    public Node(T prmValue)
    {
        atrNext = null;
        atrValue = prmValue;
    }
    
    public Node(Node<T> prmNext, T prmValue)
    {
        atrNext = prmNext;
        atrValue = prmValue;
    }
    
    public Node(Node<T> prmPrevious, Node<T> prmNext)
    {
        atrPrevious = prmPrevious;
        atrNext = prmNext;
    }
    
    public Node(Node<T> prmPrevious, Node<T> prmNext, T prmValue)
    {
        atrPrevious = prmPrevious;
        atrNext = prmNext;
        atrValue = prmValue;
    }

    public Node<T> getNext()
    {
        return atrNext;
    }

    public void setNext(Node<T> prmNode)
    {
        atrNext = prmNode;
    }
    
    public Node<T> getPrevious()
    {
        return atrPrevious;
    }
    
    public void setPrevious(Node<T> prmNode)
    {
        atrPrevious = prmNode;
    }

    public T getValue()
    {
        return atrValue;
    }

    public void setValue(T prmValue)
    {
        atrValue = prmValue;
    }
}
