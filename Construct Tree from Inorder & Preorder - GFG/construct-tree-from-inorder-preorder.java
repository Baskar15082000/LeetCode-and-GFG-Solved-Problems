//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
      public static Node cons(int pre[],int prest,int preend,int in[],int inst,int inend){
        if(prest>preend||inst>inend){
            return null;
        }
        Node root=new Node(pre[prest]);
        int i=inst;
        int count=0;
        while(true){
            if(root.data==in[i]){
                break;
            }
            i++;
            count++;
        }
        root.left=cons(pre,prest+1,prest+count,in,inst,i-1);
        root.right=cons(pre,prest+count+1,preend,in,i+1,inend);
        return root;
    }
    public static Node buildTree(int in[], int pre[], int n)
    {
        // code herreturn
        return cons(pre,0,n-1,in,0,n-1);
    }
}
