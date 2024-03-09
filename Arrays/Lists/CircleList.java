 package Libraries.Arrays.Lists;

 import Libraries.Consoles.Console;

/**
 * @author javiersolanop
 */
public class CircleList<T> extends MethodOfList<T> {
    
    private Node<T> atrFirst;
    private Node<T> atrLast;
    private int atrSize;
    
    public CircleList()
    {
        atrFirst = null;
        atrLast = null;
        atrSize = 0;
    }

    public int size()
    {
        return atrSize;
    }
    
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
            
            if(isEmpty())
                atrFirst = new Node<>(prmValue);
            atrSize++;
            return true;
        }
        return false;
    }
    
    public boolean insertBefore(T prmBefore, T prmValue)
    {
        if(find(prmBefore) && !find(prmValue))
        {
            if(atrFirst.getValue().equals(prmBefore))
                add(prmValue);
            else
            {
                insertBeforeElement(atrLast, prmBefore, prmValue);
                atrSize++;
            }
            return true;
        }
        return false;
    }
    
    public boolean insertAfter(T prmAfter, T prmValue)
    {
        if(find(prmAfter) && !find(prmValue))
        {
            if(atrLast.getValue().equals(prmAfter))
            {
                insertElementToHead(atrLast, prmValue);
                atrFirst.setValue(prmValue);
            }
            else
                insertAfterElement(atrLast, prmAfter, prmValue);
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
            
            if(atrSize == 0)
                atrFirst = null;
            return true;
        }
        return false;
    }
    
    public boolean deleteLast()
    {
        if(!isEmpty())
        {
            atrLast = atrLast.getNext();
            atrSize--;
            
            if(isEmpty())
                atrFirst = null;
            return true;
        }
        return false;
    }
    
    public boolean deleteBefore(T prmBefore)
    {
        if(find(prmBefore))
        {
            if(atrFirst.getValue().equals(prmBefore))
                deleteLast();
            else
            {
                deleteBeforeElement(atrLast, prmBefore);
                atrSize--;
            }
            return true;
        }
        return false;
    }
    
    public boolean deleteAfter(T prmAfter)
    {
        if(find(prmAfter))
        {
            if(atrLast.getValue().equals(prmAfter))
                atrFirst.setValue(deleteToHead(atrLast, atrFirst.getValue()));
            else
                deleteAfterElement(atrLast, prmAfter);
            atrSize--;   
            return true;
        }
        return false;
    }
    
    public void printList()
    {
        if(!isEmpty())
        {
            Console.titlePrint("LISTA OBTENIDA");
            Node<T>[] arrNodes = new Node[atrSize];
            NodeToVector(arrNodes, atrLast, (atrSize - 1));
            printCircleElement(arrNodes, atrFirst.getValue());
        }
    }
    
    public void printListPrevious()
    {
        if(!isEmpty())
        {
            Console.titlePrint("LISTA CIRCULAR OBTENIDA");
            printPreviousElement(atrLast, "Elemento: ");
        }
    }
}
