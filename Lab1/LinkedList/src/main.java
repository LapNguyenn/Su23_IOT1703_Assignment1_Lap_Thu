
import java.util.Scanner;

/**
 *
 * @author lap21
 */
public class main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
    //insert at head:
        System.out.println("insert 3 at head");
        list.insertAtHead(3);
        list.printList();
        System.out.println("insert 2 at head");
        list.insertAtHead(2);
        list.printList();
        System.out.println("insert 1 at head");
        list.insertAtHead(1);
        list.printList();
    //insert at tail:
        System.out.println("insert 4 at tail");
        list.insertAtTail(4);
        list.printList();
        System.out.println("insert 5 at tail");
        list.insertAtTail(5);
        list.printList();
    //delete node at head
        System.out.println("delete node at head");
        list.deleteNodeAtHead();
        list.printList();
    //delete node at last
        System.out.println("delete node at last");
        list.deleteNodeAtLast();
        list.printList();    
    //add after a node
        System.out.println("add after node number 1");
        list.addAfter(list.getNodeAtPosition(1), 9);
        list.printList();
    //delete after a node
        System.out.println("Delete node after node number 1");
        list.deleteAfter(list.getNodeAtPosition(1));
        list.printList();
    //delete node have value
        System.out.println("delete node have value 3");
        list.del(3);
        list.printList();
    //search a node
        System.out.println("search node have value 2");
        System.out.println("Data: " + list.search(2).data);
        System.out.println("Next node data: " + list.search(2).next.data);
//////////////////////////////////////////////////////////////////////////////////
    //insert at head:
        System.out.println("insert 1 at head");
        list.insertAtHead(1);
        list.printList();
        System.out.println("insert 19 at head");
        list.insertAtHead(19);
        list.printList();
        System.out.println("insert -55 at head");
        list.insertAtHead(-55);
        list.printList();
    //insert at tail:
        System.out.println("insert 20 at tail");
        list.insertAtTail(20);
        list.printList();
        System.out.println("insert 2 at tail");
        list.insertAtTail(2);
        list.printList();    
/////////////////////////////////////////////////////////////
        //Ascending sort
        System.out.print("List before sort: ");
        list.printList();
        list.AscendingSort(list);
        System.out.print("List after sort: ");
        list.printList();
       //delete exist node
        System.out.println("Deleted a node(data = 10) if exist");
        list.deleteIfExist(new Node(10));
        System.out.println("Deleted a node(data = -55) if exist");
        list.deleteIfExist(new Node(-55));
        list.printList();
        Object arr[] = list.toArray();
        list.displayArray(arr);
        //Merge list
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtHead(10);
        list2.insertAtHead(20);
        list2.insertAtHead(130);
        list2.insertAtHead(40);
        list2.insertAtHead(50);
        list2.insertAtHead(90);
        list2.insertAtHead(100);
        System.out.println("List 2:");
        list2.printList();
        System.out.println("Merged list:");
        list = list.merge2List(list, list2);  
        list.printList();
        //add before a node
        System.out.println("add 9 before node number 2");
        list.addBefore(list.getNodeAtPosition(2), 9);
        list.printList();
        System.out.println("Max value: " + list.max());
        System.out.println("Min value: " + list.min());
        System.out.println("Sum: " + list.sum(list));
        System.out.println("Size: " + list.getSize());
        System.out.printf("Average: %.1f\n", list.avg(list));
        list.AscendingSort(list);
        list.printList();
        list.checkSort(list);
        System.out.println("Insert 10");
        list.insert(10);
        list.printList();
        System.out.println("Insert 0");
        list.insert(0);
        list.printList();
        System.out.println("Insert 200");
        list.insert(200);
        list.printList();
        System.out.println("List before");
        list.printList();
        System.out.println("Reverse list");
        list.Reverse();
        list.printList();
        list.checkListEqual(list, list2);
    }
}
