/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author acer
 */
public class manage {
    
    public static void Ex1(String msg) {
        int n;
        System.out.println(msg);
        System.out.print("Enter the value of n: ");
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        int sum;
        sum = sum(n);
        System.out.println("SUM = "+ sum);

    }

    private static int sum(int n) {
        if(n<=0){
            return 0;
        }else {
            return n + sum(n-1);
        }
    }

    public static void Ex2(String msg) {
        System.out.println(msg);
        int[] arr = {-5,9,10,6,2,5,-100,593};
        int n = arr.length;
        printArr(arr);
        int minValue = findMin(arr, n);
        System.out.println("The minimum element: "+ minValue);
    }

    private static int findMin(int[] arr, int n) {
        if(n==1){
            return arr[0];
        }else{
            return Math.min(arr[n-1], findMin(arr, n-1));
        }
    }

    public static void Ex3(String msg) {
        System.out.println(msg);
        int[] arr = {-5,9,10,6,2,5,-100,593};
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(i==0){
                System.out.print("{"+ arr[0]+ ", ");
            } else if(i==(n-1)) {
                System.out.print(arr[n-1]+"}");
            }else{
                System.out.print(arr[i]+", ");
            }
        } 
        int result = findSum(arr, n);
        System.out.println("");
        System.out.println("The sum: "+ result);
    }

    private static int findSum(int[] arr, int n) {
        if(n==1){
            return arr[0];
        }else{
            return arr[n-1]+ findSum(arr, n-1);
        }
    }

    public static void Ex4(String msg) {
        System.out.println(msg);
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 2, 3, 2, 1};
        printArr(arr1);
        printArr(arr2);
        int isPld1 = isPalindrome(arr1, arr1.length);
        int isPld2 = isPalindrome(arr2, arr2.length);
        System.out.println("Array 1 is a Palindrome: "+ isPld1);
        System.out.println("Array 2 is a Palindrome: "+ isPld2);
    }

    private static void printArr(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(i==0){
                System.out.print("{"+ arr[0]+ ", ");
            } else if(i==(n-1)) {
                System.out.print(arr[n-1]+"}");
            }else{
                System.out.print(arr[i]+", ");
            }
        }
        System.out.println("");
    }

    private static int isPalindrome(int[] arr, int n) {
        if(n<=1){
            return 1;
        }else if(arr[0]==arr[n-1]){
            int subArr[] = new int[n-2];
            System.arraycopy(arr, 1, subArr, 0, n-2);
            return isPalindrome(subArr, n-2);
        } else return 0;
    }

    public static void Ex5(String msg) {
        System.out.println(msg);
        int arr[] = {-19,-8,-1,2,3,5,6,45,100,333,400};
        printArr(arr);
        System.out.print("Enter search target: ");
        Scanner sc  = new Scanner(System.in);
        int target = sc.nextInt();
        int result = binarySearch(arr, target, 0, arr.length -1);
        if(result == -1){
            System.out.println("NOT FOUND");
        }else System.out.println("Target found at index: "+ result);
    }

    private static int binarySearch(int[] arr, int target, int low, int high) {
        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] > target){
            return binarySearch(arr, target, low, mid - 1);
        }else return binarySearch(arr, target, mid+1, high);
    }

    public void Ex6(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        System.out.print("Enter the first number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = sc.nextInt();
        int result = GCD(n1, n2);
        System.out.println("The greatest common divisor of "+ n1+ " and "+ n2 +" is "+ result);
    }

    private int GCD(int n1, int n2) {
        if(n2==0){
            return n1;
        }else {
            return GCD(n2, n1%n2);
        }
    }

    public void Ex7(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        int base;
        int exponent;
        System.out.print("Enter exponent: ");
        exponent = sc.nextInt();
        System.out.print("Enter base: ");
        base = sc.nextInt();
        int result = power(exponent, base);
        System.out.println(exponent+"^"+base+ " = " + result);
    }

    private int power(int e, int b) {
        if(b==0){
            return 1;
        }else {
            return e*power(e, b-1);
        }
    }

    public void Ex8(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        int n;
        System.out.print("Enter n: ");
        n = sc.nextInt();
        int result = fact(n);
        System.out.println(n+"! = " + result);
    }

    private int fact(int n) {
        if(n==1){
            return 1;
        }else{
            return n*fact(n-1);
        }
    }

    public void Ex9(String msg) {
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        System.out.print("The n-th fibo with n = ");
        int n = sc.nextInt();
        int result = fib(n);
        System.out.println("The n-th fibo with n = "+n + " is "+ result);
    }

    private int fib(int n) {
        if(n<=2){
            return 1;
        }else {
            return fib(n-1)+ fib(n-2);
        }
    }

    public void Ex10(String msg) {
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n = ");
        int n = sc.nextInt();
        double result = addReciprocals(n);
        System.out.println("Result = "+ result);
    }

    private double addReciprocals(int n) {
        if(n==1){
            return 1.0;
        }else {
            return (1.0/n)+addReciprocals(n-1);
        }
    }

    public void Ex11(String msg) {
        Scanner sc = new Scanner (System.in);
        System.out.println(msg);
        System.out.print("S(n,k)      Enter n = ");
        int n = sc.nextInt();
        System.out.print("S(n,k)      Enter k = ");
        int k = sc.nextInt();
        int result = stirlingNumber(n,k);
        System.out.println("The Stirling number S("+n+", "+k+") = "+result);
    }

    private int stirlingNumber(int n, int k) {
        if(n==0 && k == 0){
            return 1;
        }else if (n > 0 && k == 0) {
            return 0; // Base case: s(n, 0) = 0 for n > 0
        } else if (n == 0 || k > n) {
            return 0; // Base case: s(0, k) = 0 and s(n, k) = 0 for k > n
        } else {
            return stirlingNumber(n - 1, k - 1) - (n - 1) * stirlingNumber(n - 1, k);
            // Recursive call based on the formula s(n+1, k) = s(n, k-1) - n * s(n, k)
        }
    }

    public void Ex12(String msg) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right= new TreeNode(7);
        
        int height = getHeight(root);
        System.out.println("The height of the binary tree is : "+ height);
    }

    private int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            
            return Math.max(leftHeight, leftHeight)+1;
        }
    }

    public void Ex13(String msg) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right= new TreeNode(7);
        
        int size = getSize(root);
        System.out.println("The size of the binary tree is : "+ size);
    }

    private int getSize(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            int leftHeight = getSize(root.left);
            int rightHeight = getSize(root.right);
            
            return leftHeight+ rightHeight +1;
        }
    }


}

class TreeNode {

        int info;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int info) {
            this.info = info;
            this.left = null;
            this.right = null;
        }

    }

