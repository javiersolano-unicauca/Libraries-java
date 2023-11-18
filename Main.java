import Arrays.JSON.JSON;
import Arrays.Lists.SimpleList;
import Arrays.SuperArray.SuperSimpleList;

public class Main {
    
    public static void main(String[] args) {
        
        JSON objJson = new JSON();
        objJson.add("Identificacion", 123456);
        objJson.add("Nombre", "Javier");
        objJson.add("Apellido", "Solano");

        System.out.println(objJson.toFormattedString());
    }
}
