/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author lap21
 */
public class Node {
    public Object data;
    Node left;
    Node right;
    int height;
    public Node next;

    public Node(Object data) {
        this(data, null, null);
        this.next = null;
        this.height = 1;
    }

    
    public Node(Object data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
        }
    
}
