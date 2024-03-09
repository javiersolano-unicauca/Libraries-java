 package Libraries.Arrays.Lists;

 import Libraries.Consoles.Console;

/**
 * @author javiersolanop
 * @param <T> Tipo de elemento
 */
public abstract class MethodOfList<T> {
    
    protected boolean findElement(Node<T> prmNode, T prmElement)
    {
        if(prmNode != null)
        {
            if(prmNode.getValue().equals(prmElement))
                return true;
            return findElement(prmNode.getNext(), prmElement);
        }
        return false;
    }

    protected void NodeToVector(Node<T>[] prmArray, Node<T> prmNode, int prmIndex)
    {
        if(prmNode != null)
        {
            prmArray[prmIndex] = prmNode;
            NodeToVector(prmArray, prmNode.getNext(), --prmIndex);
        }
    }

    protected void elementToVector(Object[] prmArray, Node<T> prmNode, int prmIndex)
    {
        if(prmNode != null)
        {
            prmArray[prmIndex] = prmNode.getValue();
            elementToVector(prmArray, prmNode.getNext(), --prmIndex);
        }
    }
    
    protected boolean insertBeforeElement(Node<T> prmNode, T prmBefore, T prmValue)
    {
        if(prmNode != null)
        {
            if(prmNode.getValue().equals(prmBefore))
            {
                prmNode.setNext(new Node<>(prmNode.getNext(), prmValue));
                return true;
            }
            return insertBeforeElement(prmNode.getNext(), prmBefore, prmValue);
        }
        return false;
    }
    
    protected boolean insertAfterElement(Node<T> prmNode, T prmAfter, T prmValue)
    {
        if(prmNode != null)
        {
            if(prmNode.getNext().getValue().equals(prmAfter))
            {
                prmNode.setNext(new Node<>(prmNode.getNext(), prmValue));
                return true;
            }
            return insertAfterElement(prmNode.getNext(), prmAfter, prmValue);
        }
        return false;
    }
    
    protected void insertElementToHead(Node<T> prmNode, T prmElement)
    {
        if(prmNode != null)
        {
            if(prmNode.getNext() == null)
                prmNode.setNext(new Node<>(prmElement));
            else
                insertElementToHead(prmNode.getNext(), prmElement);
        }
    }

    protected void updateElement(Node<T> prmNode, T prmValueCurrent, T prmNewValue)
    {
        if(prmNode != null)
        {
            if(prmNode.getValue().equals(prmValueCurrent))
                prmNode.setValue(prmNewValue);
            else
                updateElement(prmNode.getNext(), prmValueCurrent, prmNewValue);
        }
    }

    protected boolean deleteElement(Node<T> prmNode, T prmElement)
    {
        if(prmNode != null)
        {
            if((prmNode.getNext() != null)
            && (prmNode.getNext().getValue().equals(prmElement)))
            {
                prmNode.setNext(prmNode.getNext().getNext());
                return true;
            }
            return deleteElement(prmNode.getNext(), prmElement);
        }
        return false;
    }
    
    protected boolean deleteBeforeElement(Node<T> prmNode, T prmBefore)
    {
        if(prmNode != null)
        {
            if(prmNode.getValue().equals(prmBefore))
            {
                prmNode.setNext(prmNode.getNext().getNext());
                return true;
            }
            return deleteBeforeElement(prmNode.getNext(), prmBefore);
        }
        return false;
    }
    
    protected boolean deleteAfterElement(Node<T> prmNode, T prmAfter)
    {
        if(prmNode != null)
        {
            if(prmNode.getNext().getValue().equals(prmAfter))
            {
                prmNode.setValue(prmNode.getNext().getValue());
                prmNode.setNext(prmNode.getNext().getNext());
                return true;
            }
            return deleteAfterElement(prmNode.getNext(), prmAfter);
        }
        return false;
    }
    
    protected T deleteToHead(Node<T> prmNode, T prmHead)
    {
       if(prmNode != null)
        {
            if(prmNode.getNext().getValue().equals(prmHead))
            {
                prmNode.setNext(null);
                return prmNode.getValue();
            }
            return deleteToHead(prmNode.getNext(), prmHead);
        }
        return null;
    }
    
    protected void printElement(Node<T>[] prmNodes, String prmMessage)
    {
        for(Node<T> objNode: prmNodes)
            Console.println(prmMessage+objNode.getValue());
    }
    
    protected void printCircleElement(Node<T>[] prmNodes, T prmHead)
    {
        for(int i = 0; i < (prmNodes.length - 1); i++)
            Console.print(prmNodes[i].getValue()+" -> ");
        Console.println(prmNodes[prmNodes.length - 1].getValue()+" -> Cabeza: "+prmHead);
    }
    
    protected void printPreviousElement(Node<T> prmNode, String prmMessage)
    {
        if(prmNode != null)
        {
            Console.println(prmMessage+prmNode.getValue());
            printPreviousElement(prmNode.getNext(), prmMessage);
        }
    }
}
