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
public class BinaryTree implements TreeFunction{
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override//Search a node having value x. Return a reference to that node if found, return null otherwise
    public Node search(Object x) {
        System.out.println("Searching " + x + "..." );
        if(isEmpty()){
            System.out.println("Empty tree!");
            return null;
        }
        ArrayList<Node> list = breadth();
        for (Node node : list) {
            if(node.data == x){
                System.out.println("Found!");
                return node;
            }
        }
        System.out.println("Node not found!");
        return null;
    }
    
    Node insertNodeSortedTree(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < Integer.parseInt(root.data.toString()))
            root.left = insertNodeSortedTree(root.left, value);
        else if (value >= Integer.parseInt(root.data.toString()))
            root.right = insertNodeSortedTree(root.right, value);
        return root;
    }
    
    @Override//check if the key x does not exists in a tree then insert new node with value x into the tree
    public void insert(Object x) {
        if(search(x) != null){
            System.out.println(x + " exist!");
            return;
        }
        System.out.println("Inserting " + x + "...");
        this.root = insertNodeSortedTree(this.root, Integer.parseInt(x.toString()));
    }

    @Override
    public ArrayList breadth() {
        Queue queue = new Queue();
        ArrayList<Node> visited = new ArrayList();
        if(isEmpty()){
            System.out.println("Empty tree!");
            return null;
        }else{
            queue.enqueue(this.root);
            while (!queue.isEmpty()) {                
                Node p = queue.dequeue();
                if(p.left != null){
                    queue.enqueue(p.left);
                }
                if(p.right != null){
                    queue.enqueue(p.right);
                }
                visited.add(p);
            }
        }
        return visited;
    }
    
    public void displayTreeByBreath(){
        if(isEmpty()){
            System.out.println("Empty tree!");
            return;
        }
        ArrayList<Node> list = this.breadth();
        System.out.print("Breath: ");
        for (Node node : list) {
            System.out.print(node.data + " ");
            node = null;
        }
        System.out.println("");
    }
    
    @Override
    public void preorder() {
        if(isEmpty()){
            System.out.println("Empty tree!");
            return;
        }
        Stack stack = new Stack();
        stack.push(this.root);
        System.out.print("PreOrder: ");
        while (!stack.isEmpty()) {      
            Node popNode = stack.pop();
            
            System.out.print(popNode.data + " ");
            if(popNode.right!= null){
                stack.push(popNode.right);
            }
            if(popNode.left!= null){
                stack.push(popNode.left);
            }
        }
        System.out.println("");
    }

    @Override
    public void postorder(Node p) {
        if(p == null){
            return;
        }
        postorder(p.left);
        postorder(p.right);
        System.out.print(p.data + " ");
    }

    @Override
    public int count() {
        ArrayList<Node> list = this.breadth();
        return list.size();
    }

    @Override
    public void delete(Object x){
        if(search(x) == null){
            System.out.println("Node not exist!");
            return;
        }else{
            System.out.println("Deleting Node have value " + x);
            this.root = deleteNodeSortedTree(this.root, x);
            System.out.println("Deleted sucessfully!");
        }
        
    }
    
    public Node deleteNodeSortedTree(Node root, Object x) {
        if (root == null){
            return null;
        }
        if(Double.parseDouble(x.toString()) < Double.parseDouble(root.data.toString())){
            root.left = deleteNodeSortedTree(root.left, x);
        }else if(Double.parseDouble(x.toString()) > Double.parseDouble(root.data.toString())){
            root.right = deleteNodeSortedTree(root.right, x);
        }else{
            //Node duoi 2 con
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            //node 2 con
            Node toChange = min(root.right);//Find min node in sub right tree
            root.data = toChange.data;//change data to that node
            
            root.right = deleteNodeSortedTree(root.right, Double.parseDouble(toChange.data.toString())); //Delete the min node
        }
        return root;
    }
    
    @Override
    public Node min(Node nodeStart){
        //base case
        if(nodeStart == null){
            return null;
        }
        
        if(nodeStart.left != null){
            return min(nodeStart.left);
        }
        return nodeStart;
    }

    @Override
    public Node max(Node nodeStart) {
        //base case
        if(nodeStart == null){
            return null;
        }
        
        if(nodeStart.right != null){
            return max(nodeStart.right);
        }
        return nodeStart;
    }

    @Override
    public Object sum() {
        ArrayList<Node> list = breadth();
        double sum = 0;
        for (Node object : list) {
            sum += Double.parseDouble(object.data.toString());
        }
        return sum;
    }

    @Override
    public Object avg() {
        double avg = (double)sum()/(count());
        return avg;
    }

    @Override
    public int height(Node nodeStart) {
        if(nodeStart == null)
        return 0;
        
            int leftHeight = height(nodeStart.left);
            int rightHeight = height(nodeStart.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public Double MaxCostOfPath(Node nodeStart) {
        if(nodeStart == null){
            return 0.0;
        }
        double leftMaxCost = MaxCostOfPath(nodeStart.left);
        double leftRightCost = MaxCostOfPath(nodeStart.right);
        double max = Math.max(leftMaxCost, leftRightCost);
        return max + Double.parseDouble(root.data.toString());
    }
    


    
    @Override
    public boolean isAVLTree(Node nodeStart) {
        if(nodeStart == null){
            return true;
        }
        int heightLeftTree = this.height(nodeStart.left);
        int heightRightTree = this.height(nodeStart.right);
        int distance = Math.abs(heightLeftTree - heightRightTree);
        
        if(distance > 1){
            return false;
        }
        
        return isAVLTree(nodeStart.left) && isAVLTree(nodeStart.right);
    }

    @Override
    public boolean isHeapTree(Node nodeStart) {
        if(nodeStart == null){
            return true;
        }
        
        Double data = Double.parseDouble(nodeStart.data.toString());
        System.out.println(data);
        Double leftData = Double.parseDouble(nodeStart.left.data.toString());
        System.out.println(leftData);
        Double rightData = Double.parseDouble(nodeStart.right.data.toString());
        System.out.println(rightData);
        
        if ((data - leftData)*(data - rightData) < 0){
            return false;
        }
        
        return isHeapTree(nodeStart.left) && isHeapTree(nodeStart.right);
    }
    
    
    
    
    
}