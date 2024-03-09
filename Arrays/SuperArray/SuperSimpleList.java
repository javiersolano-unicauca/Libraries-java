package Libraries.Arrays.SuperArray;

import Libraries.Arrays.Lists.SimpleList;

/**
*  @author javiersolanop
*  @param K recibe el tipo de clave
*  @param O recibe el tipo de objeto que almacena
*/
public class SuperSimpleList<K, O> {
    
    // Properties:
    private SimpleList<Element<K, O>> atrObjects;

    // Constructors:
    public SuperSimpleList(){ atrObjects = new SimpleList<>(); }

    /**
     *  Metodo para validar si el arreglo esta vacio.
     * 
     *  @return 'true' si esta vacio. 'false' si no.
     */
    public boolean isEmpty(){ return atrObjects.isEmpty(); }

    /**
     *  Metodo para obtener el tamanio del arreglo.
     * 
     *  @return El tamanio.
     */
    public int size(){ return atrObjects.size(); }

    /**
     *  Metodo para validar si existe un elemento especifico en el arreglo.
     * 
     *  @param prmKey La clave del elemento.
     *  @return 'true' si existe. 'false' si no.
     */
    public boolean validateExistence(K prmKey)
    {
        for(Element<K, O> obj: atrObjects){
            if(obj.getKey().equals(prmKey))
                return true;
        }
        return false;
    }

    /**
     *  Metodo para adicionar un elemento al arreglo.
     * 
     *  @param prmKey recibe la clave del elemento en el arreglo.
     *  @param prmObject recibe el objeto del elemento.
     *  @return 'true' si se adiciona. 'false' si ya existe.
     */
    public boolean add(K prmKey, O prmObject)
    {
        if(!validateExistence(prmKey)){
            if(atrObjects.add(new Element<>(atrObjects.size(), prmKey, prmObject)))
                return true;
        }
        return false;
    }

    /**
     *  Metodo para obtener el objeto de un elemento especifico del arreglo.
     * 
     *  @param prmKey recibe la clave del elemento.
     *  @return El objeto, si existe el elemento. De lo contrario null.
     */
    public O get(K prmKey)
    {
        for(Element<K, O> obj: atrObjects){
            if(obj.getKey().equals(prmKey))
                return obj.getValue();
        }
        return null;
    }

    /**
     *  Metodo para obtener todos los elementos del arreglo.
     *  @return El arreglo.
     */
    public Element<K, O>[] getAll(){ 
        Element<K, O>[] vtrElements = new Element[atrObjects.size()]; 
        atrObjects.toArray(vtrElements);
        return vtrElements;
    }

    /**
     *  Metodo para obtener los objetos de cada elemento del arreglo.
     * 
     *  @return El arreglo de objetos.
     */
    public SimpleList<O> getAllObjects()
    {
        SimpleList<O> arr = new SimpleList<>();

        for(Element<K, O> obj: atrObjects)
            arr.add(obj.getValue());
        return arr;
    }

    /**
     *  Metodo para actualizar el objeto de un elemento especifico del arreglo.
     * 
     *  @param prmKey recibe la clave del elemento.
     *  @param prmObject recibe el nuevo objeto.
     *  @return 'true' si se actualiza. 'false' si no existe.
     */
    public boolean update(K prmKey, O prmObject)
    {
        for(Element<K, O> obj: atrObjects){

            if(obj.getKey().equals(prmKey)){

                Element<K, O> objElement = obj;
                obj.setValue(prmObject);
                atrObjects.update(objElement, obj);
                return true;
            }
        }
        return false;
    }

    /**
     *  Metodo para remover un elemento especifico del arreglo.
     * 
     *  @param prmKey recibe la clave del elemento.
     *  @return 'true' si lo remueve. 'false' si no existe.
     */
    public boolean remove(K prmKey)
    {
        for(Element<K, O> obj: atrObjects){
            if(obj.getKey().equals(prmKey))
               return atrObjects.delete(obj);
        }
        return false;
    }  
}
