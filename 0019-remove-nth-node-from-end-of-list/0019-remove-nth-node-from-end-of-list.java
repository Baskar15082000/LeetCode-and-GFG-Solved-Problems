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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        count=(count-n);
        if(count==0){
            head=head.next;
            return head;
        }
        count--;
        curr=head;
        while(count>0){
            curr=curr.next;
            count--;
        }
        curr.next=curr.next.next;
        return head;
    }
}