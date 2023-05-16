import java.util.InputMismatchException;
import java.util.Scanner;

/**
*  @author javiersolanop
*/

public class Console {
    
    // Properties of class:
    private static Scanner atrInput = new Scanner(System.in);

    /**
     *  Metodo para imprimir una cadena en consola.
     * 
     *  @param prmChain Recibe la cadena.
     */
    public static void println(String prmChain)
    {
        System.out.println(prmChain);
    }

    /**
     *  Metodo para imprimir una cadena en consola sin salto de linea al final.
     * 
     *  @param  prmChain Recibe la cadena.
     */
    public static void print(String prmChain)
    {
        System.out.print(prmChain);
    }

    /**
     *  Metodo para imprimir una cadena de caracteres en consola,
     *  aniade salto de linea inicial y final.
     * 
     *  @param prmMessage Recibe la cadena.
     */
    public static void printMessage(String prmMessage)
    {
        System.out.println("\n"+prmMessage+"\n");
    }

    /**
     *  Metodo para imprimir un titulo en consola,
     *  se imprime de la siguiente manera: ----- prmTitle -----
     * 
     *  @param prmTitle Recibe el titulo.
     */
    public static void titlePrint(String prmTitle)
    {
        printMessage("----- "+prmTitle+" -----");
    }

    /**
     *  Metodo para recibir entradas de tipo entero por consola.
     * 
     *  @param prmDescription Recibe la descripcion de la entrada que se solicita.
     * 
     *  @return La entrada ingresada por el usuario.
     */
    public static int integerInput(String prmDescription) throws MathException
    {
        printMessage(prmDescription+":");
        try{
            return atrInput.nextInt();
        }catch(InputMismatchException e){
            throw new MathException(MathException.NOT_INTEGER);
        }
    }

    /**
     *  Metodo para recibir entradas de tipo double por consola.
     * 
     *  @param prmDescription Recibe la descripcion de la entrada que se solicita.
     * 
     *  @return La entrada ingresada por el usuario.
     */
    public static double doubleInput(String prmDescription) throws MathException
    {
        printMessage(prmDescription+":");
        try{
            return atrInput.nextDouble();
        }catch(InputMismatchException e){
            throw new MathException(MathException.NOT_DOUBLE);
        }
    }
}