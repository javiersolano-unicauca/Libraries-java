package Arrays.Queue;

import Arrays.Queue.Node;
import Consoles.Console;

public class Queue<T> {
    
    private Node<T> atrHead;
    private Node<T> atrTail;
    private int atrSize;

    public Queue()
    {
        atrHead = null;
        atrTail = null;
        atrSize = 0;
    }

    public Node<T> getFirstNode()
    {
        return atrHead;
    }

    public int size()
    {
        return atrSize;
    }

    public boolean isEmpty()
    {
        return (atrSize == 0);
    }

    public T getFirst()
    {
        return atrHead.getValue();
    }

    public T getLast()
    {
        return atrTail.getNext().getValue();
    }

    public void push(T prmValor)
    {
        Node<T> objNode = new Node<>();
        objNode.setValue(prmValor);

        if(!isEmpty())
            objNode.setPrevious(atrTail.getNext());
        else
            atrHead = objNode;

        objNode.setNext(objNode);
        atrTail = objNode;
        atrSize++;
    }

    public boolean delete()
    {
        if(!isEmpty()){

            atrTail.setNext(atrTail.getPrevious());
            atrTail.setPrevious(atrTail.getPrevious().getPrevious());

            atrSize--;
            return true;
        }
        return false;
    }
}
