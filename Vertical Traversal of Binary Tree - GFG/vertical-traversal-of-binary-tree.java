//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int leftpos=0;
	static int rightpos=0;
	static void findlevel(Node root,int pos){
		if(root==null){
			return;
		}
		leftpos=Math.min(leftpos,pos);
		rightpos=Math.max(rightpos,pos);
		findlevel(root.left,pos-1);
		findlevel(root.right,pos+1);
		
	}
static 	class pair{
		Node node;
		 int level;
		pair(Node node,int level){
			this.node=node;
			this.level=level;
		}
	}
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        		List<List<Integer>> list=new ArrayList<>();
		if(root==null){
			return new ArrayList<>();
		}
		findlevel(root,0);
		int nolevel=rightpos-leftpos+1;
		int startpos=-leftpos;
		for(int i=0;i<nolevel;i++){
			list.add(new ArrayList<>());
		}
		Queue<pair> q=new ArrayDeque<>();
		q.add(new pair(root,startpos));
		while(q.size()>0){
			int size=q.size();
			Queue<pair> temp=new ArrayDeque<>();
			while(size-->0){
				pair p=q.remove();
				list.get(p.level).add(p.node.data);
				if(p.node.left!=null){
					temp.add(new pair(p.node.left,p.level-1));
				}
				if(p.node.right!=null){
					temp.add(new pair(p.node.right,p.level+1));
				}
				
			}
			q=temp;
		}
		ArrayList<Integer> ans=new ArrayList<>();
		for(int j=0;j<list.size();j++){
		    for(int i=0;i<list.get(j).size();i++){
		        
		    ans.add(list.get(j).get(i));
		    }
		}
		return ans;
        
        
    }
}