import Arrays.Queue.Queue;

public class Main {
    
    public static void main(String[] args) {
        
        Queue<Integer> objQueue = new Queue<>();

        objQueue.push(1);
        objQueue.push(2);
        objQueue.push(3);
        objQueue.push(4);
        objQueue.push(5);

        objQueue.delete();
        System.out.println("Primer elemento: "+objQueue.getFirst());
        System.out.println("Ultimo elemento: "+objQueue.getLast());
        objQueue.printQueue("Elemento: ");


        // System.out.println("Ultimo elemento: "+objQueue.getLast());

        // objQueue.printQueue("Elemento: ");
        Arrays.Queue.Node<Integer> obj =  objQueue.getFirstNode();
        // System.out.println(obj.getNext().getNext().getValue());
    }
}
