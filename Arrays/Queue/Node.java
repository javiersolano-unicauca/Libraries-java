package Arrays.Queue;

public class Node<T> {
    
    private Node<T> atrPrevious;
    private Node<T> atrNext;
    private T atrValue;

    public Node()
    {
        atrPrevious = null;
        atrNext = null;
        atrValue = null;
    }
    
    public Node<T> getPrevious()
    {
        return atrPrevious;
    }

    public void setPrevious(Node<T> prmNode)
    {
        atrPrevious= prmNode;
    }

    public Node<T> getNext()
    {
        return atrNext;
    }

    public void setNext(Node<T> prmNode)
    {
        atrNext = prmNode;
    }

    public T getValue()
    {
        return atrValue;
    }

    public void setValue(T prmValue)
    {
        atrValue = prmValue;
    }

    public void printNode()
    {
        System.out.println("Anterior: "+atrPrevious.getValue()+" - Siguiente: "+atrNext.getValue());
    }
}
