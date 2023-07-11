//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    
    public static Node cons(int arr[],int l,int r){
        if(id<0){
            return null;
        }
        if(arr[id]<l || arr[id]>r)return null;
       
        Node node=new Node(arr[id]);
         id--;
        node.right=cons(arr,node.data+1,r);
        node.left=cons(arr,l,node.data-1);
        return node;
    }
    static int id=0;
    public static Node constructTree(int post[],int n)
    {
        //Add your code here.
        id=n-1;
        return cons(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
    }
}