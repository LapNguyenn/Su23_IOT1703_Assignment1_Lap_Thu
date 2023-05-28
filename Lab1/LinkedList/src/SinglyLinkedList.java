
import com.sun.javafx.font.t2k.T2KFactory;
import java.util.ArrayList;

/**
 *
 * @author lap21
 */
public class SinglyLinkedList<T>{
    private Node<T> head;
    private int size;
    

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    boolean isEmpty(){
        return this.head == null;
    }
    public int getSize(){
        return this.size;
    }
    
    public void insertAtHead(T data){
        Node<T> newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }
    public void insertAtTail(T data){
        Node<T> newNode = new Node(data);
        Node<T> currentNode = this.head;
        while (true) {            
            if(currentNode.next == null){
                currentNode.next = newNode;
                this.size++;
                break;
            }else{
                currentNode = currentNode.next;
            }
        }
    }
    
    public void deleteNodeAtHead() {
        if(!isEmpty()){
            this.head = this.head.next;
            this.size--;
        }
    }
    public void deleteNodeAtLast() {
        Node<T> currentNode = this.head;
        while (true) {            
            if(currentNode.next.next == null){
                currentNode.next = null;
                this.size--;
                break;
            }else{
                currentNode = currentNode.next;
            }
        }        
    }
    public void addAfter(Node<T> p, T x) {
        Node<T> newNode = new Node(x);
        Node<T> currentNode = this.head;
        while (true) {            
            if (currentNode == p) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                this.size++;
                break;
            }else{
                currentNode = currentNode.next;
            }
        }
    }
    public void addBefore(Node<T> p, T x) {
        if(this.head == p){
            insertAtHead(x);
            return;
        }
        Node<T> newNode = new Node(x);
        Node<T> currentNode = this.head;

        while (true) {            
            if (currentNode.next == p) {
                newNode.next = p;
                currentNode.next = newNode;
                this.size++;
                break;
            }else{
                currentNode = currentNode.next;
            }
        }
    }
    public void deleteAfter(Node<T> p) {
        Node<T> currentNode = this.head;
        while (true) {
            if (currentNode == p) {
                currentNode.next = p.next.next;
                this.size--;
                break;
            }else{
                currentNode = currentNode.next;
            }
        }
    }
    
    public void del(T x) {
        Node<T> currentNode = this.head;
        if(currentNode.data == x){
            deleteNodeAtHead();
            return;
        }
        while (true) {            
            if(currentNode.next.data == x){
                currentNode.next = currentNode.next.next;
                this.size--;
                break;
            }else{
                currentNode = currentNode.next;
            }
        }
    }
    
    public Node<T> search(T x){
        Node<T> currentNode = this.head;
        while (currentNode != null) {      
            if(currentNode.data == x){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        System.out.println("Node not found!");
        return null;
    }
    
    public Node<T> getNodeAtPosition(int position){
        Node<T> currentNode = this.head;
        int count = 0;
        if(position > size-1){
            System.out.println("Node not found!");
            return null;
        }else{
            while (currentNode != null) {
                if(count == position){
                    return currentNode;
                }else{
                    currentNode = currentNode.next;
                    count++;
                }
            }            
        }
        return null;
    }
    
    
    /**
     * Ascending sort a single linked list using selection algorithm
     * @param list
     * @return 
     */
    void AscendingSort(SinglyLinkedList<T> list){
        for(Node<T> slow = this.head; slow != null; slow = slow.next){
            for (Node<T> fast = slow.next; fast != null; fast = fast.next) {
                double dataSlow = Double.parseDouble(slow.data.toString());
                double dataFast = Double.parseDouble(fast.data.toString());
                if(dataFast < dataSlow){
                    T temp = fast.data;
                    fast.data = slow.data;
                    slow.data = temp;
                }
                
            }
        }
    }
    
    public void deleteIfExist(Node<T> node) {
        if(isEmpty()){
            System.out.println("Empty list!");
            return;
        }
        if (this.head == node) {
            deleteNodeAtHead();
            return;
        }
        for (Node<T> scanNode = this.head;  scanNode.next != null; scanNode = scanNode.next) {
            if(scanNode.next == node){
                scanNode.next = scanNode.next.next;
                this.size--;
                return;
            }
        }
        System.out.println("Node not found!");
    }
    
    public Object [] toArray(){
        ArrayList<T> arrayList = new ArrayList<>();
        for (Node<T> scanNode = this.head;  scanNode != null; scanNode = scanNode.next) {
            arrayList.add(scanNode.data);
        }
        return arrayList.toArray();
    }
    
    public void displayArray(Object [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    
    public SinglyLinkedList merge2List(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> merList = new SinglyLinkedList<>();
        merList.head = list1.head;
        merList.size = list1.getSize() + list2.getSize();
        for (Node<T> scanNode = list1.head;  scanNode != null; scanNode = scanNode.next) {
            if (scanNode.next == null) {
                scanNode.next = list2.head;
                break;
            }
        }
        merList.AscendingSort(merList);
        return merList;
    }
    
    public T max() {
        Node<T> max = this.head;
        for (Node<T> scanNode = this.head;  scanNode != null; scanNode = scanNode.next) {
            if(Double.parseDouble(scanNode.data.toString()) > Double.parseDouble(max.data.toString())){
                max = scanNode;
            }
        }
        return max.data;
    }
    
    public T min() {
        Node<T> min = this.head;
        for (Node<T> scanNode = this.head;  scanNode != null; scanNode = scanNode.next) {
            if(Double.parseDouble(scanNode.data.toString()) < Double.parseDouble(min.data.toString())){
                min = scanNode;
            }
        }
        return min.data;
    }
    
    public double sum(SinglyLinkedList list){
        double sum = 0;
        Object arr[] = list.toArray();
        for (int i = 0; i < arr.length; i++) {
            sum+= Double.parseDouble(arr[i].toString());
        }
        return sum;
    }
    
    public double avg(SinglyLinkedList list){
        double sum = 0;
        Object arr[] = list.toArray();
        for (int i = 0; i < arr.length; i++) {
            sum+= Double.parseDouble(arr[i].toString());
        }
        return sum/list.getSize();
    }
    
    public boolean checkSort(SinglyLinkedList list) {
        Object templist[] = list.toArray();
        if(Double.parseDouble(list.head.data.toString()) > Double.parseDouble(list.head.next.data.toString())){
            for (int i = 0; i < templist.length; i++) {
                for (int j = i+1; j < templist.length; j++) {
                    if(Double.parseDouble(templist[j].toString()) > Double.parseDouble(templist[i].toString())){
                        System.out.println("List not sorted!");
                        return false;
                    }
                }
            }
            System.out.println("List decending sorted!");
        }else{
            for (int i = 0; i < templist.length; i++) {
                for (int j = i+1; j < templist.length; j++) {
                    if(Double.parseDouble(templist[j].toString()) < Double.parseDouble(templist[i].toString())){
                        System.out.println("List not sorted!");
                        return false;
                    }
                }
            }  
            System.out.println("List ascending sorted!");
        }
        
        return true;
    }
    
    public void insert(T x) {
        Node<T> newNode = new Node(x);
        if(Double.parseDouble(this.head.data.toString()) > Double.parseDouble(this.head.next.data.toString())){
            if(Double.parseDouble((this.head.data.toString())) < Double.parseDouble(x.toString())){
                insertAtHead(x);
            }else{
                for (Node<T> scanNode = this.head;  scanNode.next != null; scanNode = scanNode.next) {
                    if(Double.parseDouble(scanNode.next.data.toString()) < Double.parseDouble(x.toString())){
                        newNode.next = scanNode.next;
                        scanNode.next = newNode;
                        this.size++;
                        return;
                    }
                }      
                insertAtTail(x);
            }
        }else{
            if(Double.parseDouble((this.head.data.toString())) > Double.parseDouble(x.toString())){
                insertAtHead(x);
            }else{
                for (Node<T> scanNode = this.head;  scanNode.next != null; scanNode = scanNode.next) {
                    if(Double.parseDouble(scanNode.next.data.toString()) > Double.parseDouble(x.toString())){
                        newNode.next = scanNode.next;
                        scanNode.next = newNode;
                        this.size++;
                        return;
                    }
                }              
                insertAtTail(x);
            }
        }
    }
    
    public void printList() {
        if(!isEmpty()){
            Node<T> current = this.head;
            while (current != null) {                
                 System.out.print(current.data + " ");
                 current = current.next;
            }
            System.out.println(); 
        }
    }
    
    public void Reverse() {
        if(isEmpty() || this.size == 1){
            return;
        }
        for (Node<T> scanNode = this.head.next;  scanNode != null; scanNode = scanNode.next) {
            insertAtHead(scanNode.data);
            deleteIfExist(scanNode);
        }            
    }
    public boolean checkListEqual(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        if(list1.getSize() != list2.getSize()){
            System.out.println("DIFFERENT CONTENT");
            return false;            
        }
        for (Node scanList1 = list1.head, scanList2 = list2.head; scanList1 != null; scanList1 = scanList1.next, scanList2 = scanList2.next) {
            if(scanList1 != scanList2){
                System.out.println("DIFFERENT CONTENT");
                return false;
            }
        }
        System.out.println("SAME CONTENT");
        return true;
    }
}
