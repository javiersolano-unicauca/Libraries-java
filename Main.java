import Arrays.Queue.Queue;
import Arrays.SimpleList.SimpleList;

public class Main {
    
    public static void main(String[] args) {
        
        SimpleList<Integer> objSimpleList = new SimpleList<>();
        objSimpleList.add(1);
        objSimpleList.add(2);
        objSimpleList.add(3);
        objSimpleList.add(4);
        objSimpleList.printList();
        System.out.println();
        System.out.println(objSimpleList.delete(3));
        System.out.println();
        objSimpleList.printList();
    }
}
