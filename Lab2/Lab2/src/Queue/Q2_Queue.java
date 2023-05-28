package Queue;

/**
 *
 * @author lap21
 */
public interface Q2_Queue {
    boolean isEmpty();
    void clear();
    void enqueue(Object x);
    Object dequeue();
    Object first();
    void traverse();
    String FractionalToBin(double frac);
}
