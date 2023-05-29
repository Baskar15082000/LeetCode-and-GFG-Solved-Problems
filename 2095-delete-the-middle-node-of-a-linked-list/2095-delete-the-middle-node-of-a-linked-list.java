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
    public ListNode deleteMiddle(ListNode head) {
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        if(count==1){
            head=null;
            return head;
        }
        count=(count/2)-1;
        curr=head;
        while(count>0){
            count--;
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
}