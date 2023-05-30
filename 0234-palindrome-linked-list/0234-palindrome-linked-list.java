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
    public boolean isPalindrome(ListNode head) {
        ListNode curr=head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=null;
        if(head.next==null) return true;
        while(fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        ListNode head2=slow;
        ListNode curr2=head2;
        ListNode next=null;
        ListNode pre2=null;
        while(curr2!=null){
           next=curr2.next;
           curr2.next=pre2;
           pre2=curr2;
           curr2=next;
        }
        head2=pre2;
        while(head!=null){
            if(head.val!=head2.val){
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;
    }
}