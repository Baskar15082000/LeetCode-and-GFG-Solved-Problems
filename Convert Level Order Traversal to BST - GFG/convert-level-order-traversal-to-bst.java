//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java


class GFG 
{
     class pair{
		Node node;
		int l;
		int r;
		pair(Node node,int l,int r){
			this.node=node;
			this.l=l;
			this.r=r;
		}
    }
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        //Write your code here
                Queue<pair> q=new ArrayDeque<>();
                Node node=new Node(arr[0]);
                q.add(new pair(node,Integer.MIN_VALUE,node.data-1));
                q.add(new pair(node,node.data+1,Integer.MAX_VALUE));
                int in=1;
                while(q.size()>0){
                    pair p=q.remove();
                    if(in==arr.length) continue;
                    if(arr[in]<p.l || arr[in]>p.r) continue;
                    Node me =new Node(arr[in]);
                    if(me.data<p.node.data){
                        p.node.left=me;
                    }
                    else{
                        p.node.right=me;
                    }
                    in++;
                    q.add(new pair(me,p.l,me.data-1));
                    q.add(new pair(me,me.data+1,p.r));
                }
                return node;
        
    }
}