package Libraries.Arrays.Lists;

import java.util.Iterator;

 import Libraries.Consoles.Console;

/**
 * @author javiersolanop
 * @param <T> Tipo de elemento
 */
public class SimpleList<T> extends MethodOfList<T> implements Iterable<T> {

    private Node<T> atrFirst;
    private Node<T> atrLast;
    private int atrSize;

    public SimpleList()
    {
        atrFirst = null;
        atrLast = null;
        atrSize = 0;
    }

    public T getFirst()
    {
        return atrFirst.getValue();
    }
    
    public T getLast()
    {
        return atrLast.getValue();
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

    public boolean update(T prmValueCurrent, T prmNewValue)
    {
        if(find(prmValueCurrent) && !find(prmNewValue))
        {
            if(atrFirst.getValue().equals(prmValueCurrent))
                atrFirst.setValue(prmNewValue);
            updateElement(atrLast, prmValueCurrent, prmNewValue);
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

    public void toArray(T[] prmArray)
    {
        if(!isEmpty())
            elementToVector(prmArray, atrLast, (atrSize - 1));
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(atrLast);
    }
}
