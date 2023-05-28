package Queue;

/**
 *
 * @author lap21
 */
public class Main {
    
    public static void main(String[] args) {
        final QueueLinkedList queue = new QueueLinkedList();
        queue.traverse();
        System.out.println("Enqueue node");
        queue.enqueue(10);
        queue.enqueue(2);
        queue.enqueue(11);
        queue.enqueue(-9);
        queue.enqueue(13);
        queue.enqueue(3);
        System.out.println("After enqueue");
        queue.traverse();
        queue.dequeue();
        System.out.println("Dequeue");
        queue.traverse();
        System.out.println("First node: " + queue.first());
        System.out.println("Fractional to bin");
        System.out.println("Fractional: 0.6875");
        System.out.println("Bin: " + queue.FractionalToBin(0.6875));
        System.out.println("Fractional: 34.6875");
        System.out.println("Bin: " + queue.FractionalToBin(34.6875));
        
        System.out.println("Clearing queue");
        queue.clear();
        queue.traverse();
        System.out.println("String enqueue");
        queue.enqueue("Nguyen");
        queue.enqueue("Thanh");
        queue.enqueue("Lap");
        queue.enqueue("DorePita");
        System.out.println("New queue: ");
        queue.traverse();
        System.out.println("Dequeue 2 elements");
        queue.dequeue();
        queue.dequeue();
        queue.traverse();
        System.out.println("First element: " + queue.first());
        System.out.println("Clearing queue");
        queue.clear();
        queue.traverse();
    }
}
