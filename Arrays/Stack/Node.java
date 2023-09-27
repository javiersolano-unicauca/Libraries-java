package Libraries.Arrays.Stack;

public class Node<T> {
    
    private Node<T> atrLink;
    private T atrValue;

    public Node()
    {
        atrLink = null;
        atrValue = null;
    }
    
    public Node<T> getNode()
    {
        return atrLink;
    }

    public void setNode(Node<T> prmNode)
    {
        atrLink = prmNode;
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
