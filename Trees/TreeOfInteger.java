package Libraries.Trees;

import Libraries.Consoles.Console;

/**
 * @author javiersolanop
 */
public class TreeOfInteger extends Tree<Integer> {

    // Constructors:

    public TreeOfInteger()
    {
        super();
    }

    // Recursive methods:

    /**
     *  Metodo para insertar un nodo en el arbol recursivamente
     * 
     *  @param prmNode  Recibe el nodo a insertar
     *  @param prmValue Recibe el valor del nodo
     * 
     *  @return El nodo insertado 
     */
    private Node<Integer> insertNode(Node<Integer> prmNode, Integer prmValue)
    {
        if(prmNode == null)
            prmNode = new Node<>(prmValue);
        else
        {
            if(prmNode.getValue() > prmValue)
                prmNode.setLeft(insertNode(prmNode.getLeft(), prmValue));  
            
            if(prmNode.getValue() < prmValue)
                prmNode.setRight(insertNode(prmNode.getRight(), prmValue)); 
        }
        return prmNode;
    }

    // Methods:

    @Override
    public void insert(Integer prmValue)
    {
        if(atrRoot.getValue() == null)
            atrRoot.setValue(prmValue);
        else
            insertNode(atrRoot, prmValue);
    }
}