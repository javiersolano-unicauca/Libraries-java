package Arrays.SimpleList;

import Arrays.SimpleList.Node;
import Consoles.Console;

public class SimpleList<T> {

    private Node<T> atrLast;
    private int atrSize;

    public SimpleList()
    {
        atrLast= null;
        atrSize = 0;
    }

    // Private methods:

    private boolean findElement(Node<T> prmNode, T prmElement)
    {
        if(prmNode != null)
        {
            if(prmNode.getValue().equals(prmElement))
                return true;
            return findElement(prmNode.getNext(), prmElement);
        }
        return false;
    }

    private void NodeToVector(Node<T>[] prmArray, Node<T> prmNode, int prmIndex)
    {
        if(prmNode != null)
        {
            prmArray[prmIndex] = prmNode;
            NodeToVector(prmArray, prmNode.getNext(), --prmIndex);
        }
    }

    private boolean deleteElement(Node<T> prmNode, T prmElement)
    {
        if(prmNode != null)
        {
            if((prmNode.getNext() != null)
            && (prmNode.getNext().getValue().equals(prmElement)))
            {
                prmNode.setNext(prmNode.getNext().getNext());
                return true;
            }
            deleteElement(prmNode.getNext(), prmElement);
        }
        return false;
    }

    private void printElement(Node<T>[] prmNodes, String prmMessage)
    {
        for(Node<T> objNode: prmNodes)
            Console.println(prmMessage+objNode.getValue());
    }

    // Public methods

    public boolean isEmpty()
    {
        return (atrSize == 0);
    }

    public boolean find(T prmValue)
    {
        return findElement(atrLast, prmValue);
    }

    public boolean add(T prmValue)
    {
        if(!find(prmValue))
        {
            Node<T> objNode = new Node<>();
            objNode.setValue(prmValue);
            objNode.setNext(atrLast);

            atrLast = objNode;
            atrSize++;
            return true;
        }
        return false;
    }

    public boolean delete(T prmValue)
    {
        if(find(prmValue))
        {
            if(atrLast.getValue().equals(prmValue))
                atrLast = atrLast.getNext();
            else
                deleteElement(atrLast, prmValue);
            atrSize--;
            return true;
        }
        return false;
    }

    public void printList()
    {
        if(!isEmpty())
        {
            Node<T>[] arrNodes = new Node[atrSize];
            NodeToVector(arrNodes, atrLast, (atrSize - 1));
            printElement(arrNodes, "Elemento: ");
        }
    }
}
