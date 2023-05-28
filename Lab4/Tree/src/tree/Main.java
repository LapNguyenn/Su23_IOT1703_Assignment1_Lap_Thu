package tree;

/**
 *
 * @author lap21
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        tree.insert(9);
        tree.insert(20);
        tree.insert(4);
        tree.insert(15);
        tree.insert(14);
        tree.insert(18);
        tree.insert(17);
        tree.insert(19);
        tree.insert(11);
        tree.insert(3);
        tree.displayTreeByBreath();
        Node find = tree.search(9);
        System.out.println("Data: " + find.data);
        if(find.left != null){
            System.out.println("Left: " + find.left.data);
        }
        if(find.right != null){
            System.out.println("Right: " + find.right.data);
        }
        find = tree.search(200);
        tree.preorder();
        System.out.print("PostOrder: ");
        tree.postorder(tree.root);
        System.out.println("");
        tree.displayTreeByBreath();
        System.out.println("Number of node: " + tree.count());
        System.out.println("Min: " + tree.min(tree.root).data);
        System.out.println("Max: " + tree.max(tree.root).data);
        System.out.println("Sum: " + tree.sum());
        System.out.println("Avg: " + tree.avg());
        tree.displayTreeByBreath();
        tree.delete(15);
        tree.displayTreeByBreath();
        System.out.println("Height: " + tree.height(tree.root));
        System.out.println("Max Cost Path: " + tree.MaxCostOfPath(tree.root));
        if(tree.isAVLTree(tree.root)){
            System.out.println("AVL TREE!");
        }else{
            System.out.println("Not a AVL tree!");
        }
        if(tree.isHeapTree(tree.root)){
            System.out.println("Heap tree!");
        }else{
            System.out.println("Not a heap tree!");
        }
    }    
}
