/**
*  @author javiersolanop
*/

public class MathException extends Exception {

    // Properties of object:
    private String atrMessage;

    // Properties of class:
    public static final int DIVISION = 1;
    public static final int NOT_INTEGER = 2;
    public static final int NOT_DOUBLE = 3;

    // Constructors:
    public MathException(int prmTypeException)
    {
        generateMessage(prmTypeException);
    }

    // Methods:
    private void generateMessage(int prmTypeException)
    {
        switch(prmTypeException){

            case DIVISION: atrMessage = "La division entre cero no esta definida!"; break;
            case NOT_INTEGER: atrMessage = "El dato ingresado no es un numero entero!"; break;
            case NOT_DOUBLE: atrMessage = "El dato ingresado no es un numero real!"; break;
        }
    }

    @Override
    public String getMessage()
    {
        return atrMessage;
    }
}