package main.java.Libraries.Trees;

import Libraries.Consoles.Console;

/**
 * @author javiersolanop
 * 
 * @param Type Recibe el tipo de dato que almacena el arbol
 */
public abstract class Tree<Type> {
    
    protected Node<Type> atrRoot;

    // Constructors: 

    public Tree()
    {
        atrRoot = new Node();
    }

    // Recursive methods:

    /**
     *  Metodo para recorrer un nodo recursivamente de la forma 'pre-orden'
     * 
     * @param prmNode Recibe el nodo a recorrer
     */
    private void preTour(Node<Type> prmNode)
    {
        if(prmNode != null)
        {
            Console.print(prmNode.getValue() + " ");
            preTour(prmNode.getLeft());
            preTour(prmNode.getRight());
        }
    }

    /**
     *  Metodo para recorrer un nodo recursivamente de la forma 'in-orden'
     * 
     * @param prmNode Recibe el nodo a recorrer
     */
    private void inTour(Node<Type> prmNode)
    {
        if(prmNode != null)
        {
            inTour(prmNode.getLeft());
            Console.print(prmNode.getValue() + " ");
            inTour(prmNode.getRight());
        }
    }

    /**
     *  Metodo para recorrer un nodo recursivamente de la forma 'post-orden'
     * 
     * @param prmNode Recibe el nodo a recorrer
     */
    private void postTour(Node<Type> prmNode)
    {
        if(prmNode != null)
        {
            postTour(prmNode.getLeft());
            postTour(prmNode.getRight());
            Console.print(prmNode.getValue() + " ");            
        }
    }

    // Methods:

    /**
     * Metodo para insertar un valor en el arbol
     * 
     * @param prmValue Recibe el valor a insertar
     */
    public abstract void insert(Type prmValue);

    /**
     *  Metodo para recorrer el arbol recursivamente de la forma 'pre-orden'
     */
    public void preOfTreeTour()
    {
        preTour(atrRoot);
        Console.println("");
    }

    /**
     *  Metodo para recorrer el arbol recursivamente de la forma 'in-orden'
     */
    public void inOfTreeTour()
    {
        inTour(atrRoot);
        Console.println("");
    }

    /**
     *  Metodo para recorrer el arbol recursivamente de la forma 'post-orden'
     */
    public void postOfTreeTour()
    {
        postTour(atrRoot);
        Console.println("");
    }
}
