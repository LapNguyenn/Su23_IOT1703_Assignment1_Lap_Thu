/**
 *
 * @author lap21
 */
public class Node<T> {
    public T data;
    public Node<T> next;
    
    public Node(T info) {
        this.data = info;
        this.next = null;
    }
}
