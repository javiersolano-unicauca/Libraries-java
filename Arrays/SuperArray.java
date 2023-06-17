package Libraries.Arrays;

import java.util.ArrayList;

/**
*  @author javiersolanop
*  @param K recibe el tipo de clave
   @param O recibe el tipo de objeto que almacena
*/

public class SuperArray<K, O> {

    // Properties:
    private K atrKey;
    private O atrObject;
    private int atrIndex;
    private ArrayList<SuperArray<K, O>> atrObjects;

    // Constructors:
    public SuperArray()
    { 
        atrIndex = 0;
        atrObjects = new ArrayList<>(); 
    }

    private SuperArray(K prmKey, O prmObject, int prmIndex)
    {
        atrKey = prmKey;
        atrObject = prmObject;
        atrIndex = prmIndex;
        atrObjects = null;
    }
    
    /**
     *  Metodo para validar si el arreglo esta vacio.
     * 
     *  @return 'true' si esta vacio. 'false' si no.
     */
    public boolean isEmpty(){ return (atrIndex == 0); }

    /**
     *  Metodo para obtener el tamanio del arreglo.
     * 
     *  @return el tamanio.
     */
    public int size(){ return atrIndex; }

    /**
     *  Metodo para validar si existe un objeto especifico en el arreglo.
     * 
     *  @param prmKey La clave del objeto.
     *  @return 'true' si existe. 'false' si no.
     */
    public boolean validateExistence(K prmKey)
    {
        for(SuperArray<K, O> obj: atrObjects){
            if(obj.atrKey == prmKey)
                return true;
        }
        return false;
    }

    /**
     *  Metodo para adicionar un objeto al arreglo.
     * 
     *  @param prmKey recibe la clave del objeto en el arreglo.
     *  @param prmObject recibe el objeto.
     *  @return 'true' si se adiciona. 'false' si ya existe.
     */
    public boolean add(K prmKey, O prmObject)
    {
        if(!validateExistence(prmKey)){
            if(atrObjects.add(new SuperArray<>(prmKey, prmObject, atrIndex))){
                atrIndex ++;
                return true;
            }
        }
        return false;
    }

    /**
     *  Metodo para obtener un objeto especifico del arrelgo.
     * 
     *  @param prmKey recibe la clave del objeto.
     *  @return El objeto, si existe. De lo contrario null.
     */
    public O get(K prmKey)
    {
        for(SuperArray<K, O> obj: atrObjects){
            if(obj.atrKey == prmKey)
                return atrObjects.get(obj.atrIndex).atrObject;
        }
        return null;
    }

    /**
     *  Metodo para obtener todos los objetos del arreglo.
     * 
     *  @return El arreglo de objetos.
     */
    public ArrayList<O> getAll()
    {
        ArrayList<O> arr = new ArrayList<>();

        for(SuperArray<K, O> obj: atrObjects)
            arr.add(obj.atrObject);
        return arr;
    }

    /**
     *  Metodo para actualizar un objeto especifico del arreglo.
     * 
     *  @param prmKey recibe la clave del objeto.
     *  @param prmObject recibe el nuevo objeto.
     *  @return 'true' si se actualiza. 'false' si no existe.
     */
    public boolean update(K prmKey, O prmObject)
    {
        for(SuperArray<K, O> obj: atrObjects){
            if(obj.atrKey == prmKey)
                atrObjects.set(obj.atrIndex, new SuperArray<>(prmKey, prmObject, obj.atrIndex));
                return true;
        }
        return false;
    }

    /**
     *  Metodo para remover un objeto especifico del arreglo.
     * 
     *  @param prmKey recibe la clave del objeto.
     *  @return 'true' si lo remueve. 'false' si no existe.
     */
    public boolean remove(K prmKey)
    {
        for(SuperArray<K, O> obj: atrObjects){
            if(obj.atrKey == prmKey)
               return atrObjects.remove(obj);
        }
        return false;
    }
}
