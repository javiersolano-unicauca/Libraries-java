import java.util.ArrayList;

/**
*  @author javiersolanop
*/

public class SuperArray<T> {

    // Properties:
    private int atrId;
    private T atrObject;
    private int atrIndexOfArray;
    private ArrayList<SuperArray<T>> atrSuperArrays;

    // Constructors:
    public SuperArray(){
        atrSuperArrays = new ArrayList<>();
    }

    public SuperArray(int prmId, T prmObject)
    {
        atrId = prmId;
        atrObject = prmObject;
    }

    // Methods 'getter':
    public int getId() { return atrId; }

    public T getObject() { return atrObject; }

    // Methods:
    
    /**
     *  Metodo para obtener la cantidad de objetos del arreglo.
     * 
     *  @return La cantidad
     */
    public int size() { return atrSuperArrays.size(); }


    /**
     *  Metodo para saber si el arreglo no contiene objetos.
     * 
     *  @return 'true' si no contiene objetos. 'false' si contiene.
     */
    public boolean isEmpty(){ return atrSuperArrays.isEmpty(); }

    /**
     *  Metodo para buscar un objeto en el arreglo.
     * 
     *  @param prmId Recibe el 'id' por el que se filtra el objeto.
     * 
     *  @return El objeto, si existe en el arreglo. 'null' si no existe.
     */
    public T searchAndGet(int prmId)
    {
        if(!isEmpty()){

            for(SuperArray<T> obj: atrSuperArrays){

                if(obj.atrId == prmId)
                    return obj.atrObject;
            }
        }
        return null;
    }

    /**
     *  Metodo para validar si existe un objeto en el arreglo. 
     * 
     *  @param prmId Recibe el 'id' por el que se filtra el objeto.
     * 
     *  @return 'true' si existe. 'false' si no.
     */
    public boolean validateExistence(int prmId)
    {
        if(!isEmpty()){

            for(SuperArray<T> obj: atrSuperArrays){

                if(obj.atrId == prmId)
                    return true;
            }
        }
        return false;
    }

    /**
     *  Metodo para agregar un objeto al arreglo.
     * 
     *  @param prmId Recibe el 'id' como el identificador del objeto en el arreglo.
     *  @param prmObject Recibe el objeto.
     * 
     *  @return 'true' si se agrega. 'false' si ya existe un objeto con ese identificador.
     */
    public boolean addObject(int prmId, T prmObject)
    {
        if(!validateExistence(prmId)){

            SuperArray<T> objSuperArray = new SuperArray<>(prmId, prmObject);
            objSuperArray.atrIndexOfArray = atrSuperArrays.size();
            atrSuperArrays.add(objSuperArray);

            return true;
        }
        return false;
    }

    /**
     *  Metodo para obtener todos los objetos del arreglo.
     * 
     *  @return El arreglo de objetos.
     */
    public ArrayList<T> getObjects()
    {
        ArrayList<T> arrObjects = new ArrayList<>();

        if(!isEmpty()){

            for(SuperArray<T> obj: atrSuperArrays)
                arrObjects.add(obj.atrObject);
        }
        return arrObjects;
    }

    /**
     *  Metodo para actualizar un objeto del arreglo.
     * 
     *  @param prmId Recibe el 'id' por el que se filtra el objeto.
     *  @param prmObject Recibe el objeto nuevo.
     * 
     *  @return 'true' si actualiza el objeto. 'false' si no existe un objeto con ese 'id'.
     */
    public boolean updateObject(int prmId, T prmObject)
    {
        if(!isEmpty()){

            for(SuperArray<T> obj: atrSuperArrays){

                if(obj.atrId == prmId){
                    obj.atrObject = prmObject;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  Metodo para eliminar un objeto del arreglo.
     * 
     *  @param prmId Recibe el 'id' por el que se filtra el objeto.
     * 
     *  @return 'true' si se elimina. 'false' si no existe el objeto.
     */
    public boolean deleteObject(int prmId)
    {
        if(!isEmpty()){

            for(SuperArray<T> obj: atrSuperArrays){

                if(obj.atrId == prmId){
                    atrSuperArrays.remove(obj.atrIndexOfArray);
                    return true;
                }
            }
        }
        return false;
    }
}