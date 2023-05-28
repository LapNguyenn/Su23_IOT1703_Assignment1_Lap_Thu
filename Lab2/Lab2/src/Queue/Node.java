package Queue;

/**
 *
 * @author lap21
 */
public class Node {
    Object data;
    Node next;
    
    public Node(Object data) {
        this(data, null);
    }

    public Node(Object data, Node nextNode) {
        this.data = data;
        this.next = nextNode;
    }
    
    
    
}
