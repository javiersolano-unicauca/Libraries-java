 package Libraries.Arrays.Lists;

 import Libraries.Consoles.Console;

/**
 * @author javiersolanop
 * @param <T> Tipo de elemento
 */
public class List<T> extends MethodOfList<T> {
    
    private Node<T> atrFirst;
    private Node<T> atrLast;
    private int atrSize;

    public List()
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
            if(isEmpty())
                atrFirst = new Node<>(prmValue);
            else
                atrLast.setPrevious(new Node<>(prmValue));
            
            Node<T> objNode = new Node<>();
            objNode.setValue(prmValue);
            objNode.setNext(atrLast);
            atrLast = objNode;
            
            atrSize++;
            return true;
        }
        return false;
    }
    
    public boolean insertBefore(T prmBefore, T prmValue)
    {
        if(find(prmBefore) && !find(prmValue))
        {
            insertBeforeElement(atrLast, prmBefore, prmValue);
            atrSize++;
            return true;
        }
        return false;
    }
    
    public boolean insertAfter(T prmAfter, T prmValue)
    {
        if(find(prmAfter) && !find(prmValue))
        {
            if(atrLast.getValue().equals(prmAfter))
                add(prmValue);
            else
            {
                insertAfterElement(atrLast, prmAfter, prmValue);
                atrSize++;
            }
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
    
    public boolean deleteBefore(T prmBefore)
    {
        if(find(prmBefore))
        {
            if(!atrFirst.getValue().equals(prmBefore))
            {
                deleteBeforeElement(atrLast, prmBefore);
                atrSize--;
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteAfter(T prmAfter)
    {
        if(find(prmAfter))
        {
            if(!atrLast.getValue().equals(prmAfter))
            {
                deleteAfterElement(atrLast, prmAfter);
                atrSize--;
                return true;
            }
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

    public void printList()
    {
        if(!isEmpty())
        {
            Console.titlePrint("LISTA OBTENIDA");
            Node<T>[] arrNodes = new Node[atrSize];
            NodeToVector(arrNodes, atrLast, (atrSize - 1));
            printElement(arrNodes, "Elemento: ");
        }
    }
    
    public void printListPrevious()
    {
        if(!isEmpty())
        {
            Console.titlePrint("LISTA OBTENIDA");
            printPreviousElement(atrLast, "Elemento: ");
        }
    }
}
