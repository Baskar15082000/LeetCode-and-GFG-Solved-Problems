//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
     static Node rev(Node head){
       Node curr=head;
       Node next=null;
       Node pre=null;
       while(curr!=null){
           next=curr.next;
           curr.next=pre;
           pre=curr;
           curr=next;
       }
       head=pre;
       return head;
        
    }
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node head1=rev(first);
        Node head2=rev(second);
        Node newhead=null;
        Node newtail=null;
        int carr=0;
        while(head1!=null || head2!=null || carr!=0){
            int sum=0;
            if(head1!=null){
                sum=sum+head1.data;
                head1=head1.next;
            }
            if(head2!=null){
                sum=sum+head2.data;
                head2=head2.next;
            }
            int val=sum+carr;
            int val2=val%10;
            carr=val/10;
            Node newnode=new Node(val2);
            if(newhead==null){
                newhead=newnode;
                newtail=newnode;
            }
            else{
                newtail.next=newnode;
                newtail=newnode;
            }
        }
        return rev(newhead);
    }
}