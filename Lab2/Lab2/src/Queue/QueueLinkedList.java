package Queue;

/**
 *
 * @author lap21
 */
public class QueueLinkedList implements Q2_Queue{
    ////////-----DECLARE-----///////////
    protected  Node head, tail;
    
    
    
    public QueueLinkedList() {
        this.head = this.tail = null;
    }

    
    
    
    ////////-----FUNCTION-----///////////

    @Override
    public boolean isEmpty() {
        return (this.head == null);
    }

    @Override
    public void clear() {
        Node current = this.head;
        while (current != null) {            
            current.data = null;
            current = current.next;
        }
        this.head = this.tail = null;
    }

    @Override
    public void enqueue(Object x) {
        Node newNode = new Node(x);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    @Override
    public Object dequeue() {
        Node firstNode = this.head;
        Node tempNode = this.head.next;
        this.head = null;
        this.head = tempNode;
        return firstNode.data;
    }

    @Override
    public Object first() {
        return this.head.data;
    }

    @Override
    public void traverse() {
        if(isEmpty()){
            System.out.println("Empty queue!");
            return;
        }
        Node currentNode = this.head;
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    @Override
    public String FractionalToBin(double frac) {
        QueueLinkedList newQueue = new QueueLinkedList();
        int dec = (int)frac;
        frac = frac - dec;
        while(dec!=0){
            newQueue.enqueue(dec%2);
            dec/=2;
        }
        if(dec == 0){
            newQueue.enqueue(0);
        }
        newQueue.enqueue('.');
        while(frac!=0){
            frac = frac*2;
            newQueue.enqueue((int)frac);
            if(frac >=1){
                frac-= 1;
            }
        }
        String bin = "";
        while (!newQueue.isEmpty()) {            
            bin += newQueue.dequeue();
        }
        return bin;
    }
    
}
