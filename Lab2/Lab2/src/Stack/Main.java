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
public class Main {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray();
        stackArray.traverse();
        System.out.println("PUSH");
        stackArray.push(10);
        stackArray.push(-2);
        stackArray.push(14);
        stackArray.push(43);
        stackArray.push(54);
        stackArray.push(92);
        stackArray.push(1);
        stackArray.push(2);
        System.out.println("Stack after push values");
        stackArray.traverse();
        System.out.println("POP 2 value");
        stackArray.pop();
        stackArray.pop();
        System.out.println("After pop");
        stackArray.traverse();
        System.out.println("Top value: " + stackArray.top());
        System.out.println("Dec to bin:");
        System.out.println("Dec: 1000");
        System.out.println("Bin: " + stackArray.DecToBin(1000));
        
        ///////////STRING TYPE
        System.out.println("Clearing stack...");
        stackArray.clear();
        stackArray.traverse();
        System.out.println("Push");
        stackArray.push("Nguyen");
        stackArray.push("Thanh");
        stackArray.push("Lap");
        stackArray.push("DorePita");
        System.out.println("New stack data:");
        stackArray.traverse();
        ///////////Character TYPE
        System.out.println("Clearing stack...");
        stackArray.clear();
        stackArray.traverse();
        System.out.println("Push");
        stackArray.push('l');
        stackArray.push('a');
        stackArray.push('p');
        System.out.println("New stack data:");
        stackArray.traverse();
        
    }
}
