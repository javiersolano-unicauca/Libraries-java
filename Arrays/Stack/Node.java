// package Libraries.Arrays.Stack;
package Arrays.Stack;

public class Node<T> {
    
    private Node<T> atrNext;
    private T atrValue;

    public Node()
    {
        atrNext = null;
        atrValue = null;
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
}
