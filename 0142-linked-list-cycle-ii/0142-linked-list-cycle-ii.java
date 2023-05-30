/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode curr=head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode meeting=null;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                meeting =slow;
                break;
            }
        }
        if(meeting==null) return meeting;
        ListNode node=head;
        while(node!=meeting){
            node=node.next;
            meeting=meeting.next;
        }
       
        return node;
    }
}