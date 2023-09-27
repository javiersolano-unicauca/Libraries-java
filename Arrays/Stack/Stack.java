package Libraries.Arrays.Stack;

import Libraries.Consoles.Console;

public class Stack<T> {
    
    private Node<T> atrLast;
    private int atrSize;

    public Stack()
    {
        atrLast = null;
        atrSize = 0;
    }

    public boolean isEmpty()
    {
        return (atrSize == 0);
    }

    public T getLast()
    {
        return (!isEmpty()) ? atrLast.getValue() : null;
    }

    public Node<T> getLastNode()
    {
        return atrLast;
    }

    public void stackUp(T prmValue)
    {
        Node<T> objNode = new Node<>();
        objNode.setNode(atrLast);
        objNode.setValue(prmValue);

        atrLast = objNode;
        atrSize++;
    }

    public boolean unstack()
    {
        if(!isEmpty())
        {
            atrLast = atrLast.getNode();
            atrSize--;
            return true;
        }
        return false;
    }

    private void printElement(Node<T> prmNode, String prmMessage)
    {
        if(prmNode != null)
        {
            Console.printMessage(prmMessage+prmNode.getValue());
            printElement(prmNode.getNode(), prmMessage);
        }
    }

    public void printStack(String prmMessage)
    {
        printElement(atrLast, prmMessage);
    }
}