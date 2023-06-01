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
    public ListNode oddEvenList(ListNode head) {
        ListNode curr=head;
       ListNode head1=null;
		ListNode  head2=null;
		ListNode tail1=null;
		ListNode tail2=null;
        int count=0;
        if(head==null || head.next==null)return head;
	    while(curr!=null){
			ListNode newnode=curr;
			if(count%2==0){
				if(head1==null){
					head1=newnode;
					tail1=newnode;
				}
				else{
					tail1.next=newnode;
					tail1=newnode;
				}
				
			}
			else if(count%2!=0){
				if(head2==null){
					head2=newnode;
					tail2=newnode;
				}
				else{
					tail2.next=newnode;
					tail2=newnode;
				}
				
			}
			curr=curr.next;
            count++;
		}
		tail1.next=null;
		tail2.next=null;
		tail1.next=head2;
        return head1;
    }
}