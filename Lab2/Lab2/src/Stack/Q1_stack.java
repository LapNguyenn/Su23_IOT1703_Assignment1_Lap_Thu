/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author lap21
 */
public interface Q1_stack<Object> {
    public boolean isEmpty();
    public void clear();
    public void push(Object x);
    public Object pop();
    public Object top();
    public void traverse();
    public String DecToBin(int dec);
}
