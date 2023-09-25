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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        if(head==null || k<=1)return head;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        ListNode headtemp=new ListNode(0);
        ListNode st=head;
        curr=head;
        int t=1;
        while(count>=k){
            curr=curr.next;
            t++;
            if(t==k){
                ListNode newnode=curr.next;
                curr.next=null;
                
                ListNode current=st;
	         	ListNode next=null;
	        	ListNode pre=null;
		        while(current!=null){
			            next=current.next;
			            current.next=pre;
			            pre=current;
			            current=next;
			
	        	}
               // System.out.print(pre.val);
                st=newnode;
                ListNode temp=headtemp;
                while(temp.next!=null){
                    temp=temp.next;
                }
	        	temp.next=pre;
                curr=newnode;
                t=1;
                count=count-k;
            }
        }
        ListNode c=headtemp;
        while(c.next!=null){
            c=c.next;
        }
        c.next=curr;
        return headtemp.next;
    }
}