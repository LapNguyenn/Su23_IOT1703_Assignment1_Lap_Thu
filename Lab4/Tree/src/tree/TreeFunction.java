/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;
import java.util.ArrayList;
/**
 *
 * @author lap21
 */
public interface TreeFunction {
    boolean isEmpty();
    void clear();
    Node search(Object x);
    void insert(Object x);
    ArrayList<Node> breadth();
    void preorder();
    void postorder(Node p);
    int count();
    void delete(Object x);
    Node min(Node nodeStart);
    Node max(Node nodeStart);
    Object sum();
    Object avg();
    int height(Node nodeStart);
    Double MaxCostOfPath(Node nodeStart);
    boolean isAVLTree(Node nodeStart);
    boolean isHeapTree(Node nodeStart);
}
