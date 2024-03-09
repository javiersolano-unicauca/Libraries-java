package Libraries.Trees;

/**
 * @author javiersolanop
 * 
 * @param Type Recibe el tipo de dato que almacena el nodo
 */
public class Node<Type> {
    
    private Type atrValue;
    private Node<Type> atrLeft;
    private Node<Type> atrRight;

    // Constructors: 

    public Node()
    {
        atrValue = null;
        atrLeft = null;
        atrRight = null;
    }

    public Node(Type prmValue)
    {
        atrValue = prmValue;
        atrLeft = null;
        atrRight = null;
    }

    public Node(Type prmValue, Node<Type> prmLeft, Node<Type> prmRight)
    {
        atrValue = prmValue;
        atrLeft = prmLeft;
        atrRight = prmRight;
    }

    // Methods 'setter' and 'getter':

    public Type getValue()
    {
        return atrValue;
    }

    public void setValue(Type prmValue)
    {
        atrValue = prmValue;
    }

    public Node<Type> getLeft()
    {
        return atrLeft;
    }

    public void setLeft(Node<Type> prmLeft)
    {
        atrLeft = prmLeft;
    }

    public Node<Type> getRight()
    {
        return atrRight;
    }

    public void setRight(Node<Type> prmRight)
    {
        atrRight = prmRight;
    }
}
