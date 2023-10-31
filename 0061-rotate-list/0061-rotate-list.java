/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)return head; 
            ListNode curr=head;
        int n=0;
        while(curr!=null){
            curr=curr.next;
            n++;
        }
       k=k%n;
        if(k==0)return head;
         n=n-k;
         n--;
       
        
        curr=head;
        while(n>0){
            curr=curr.next;
            n--;
        }
        ListNode pre=curr;
		
		ListNode newhead=curr.next;
		pre.next=null;
		ListNode c=newhead;
		ListNode f=null;
	    while(c!=null){
			f=c;
			c=c.next;
		}
		
		f.next=head;
		head=newhead;
        return head;
       
        
        
    }
}