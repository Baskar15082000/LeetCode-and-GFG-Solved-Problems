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
    public int gcd(int a,int b){
         while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode f1=head;
        ListNode f2=head.next;
        while(f2!=null && f1!=f2){
            int gcd=gcd(f1.val,f2.val);
            ListNode newnode=new ListNode(gcd);
            
            newnode.next=f2;
            f1.next=newnode;
            f1=f2;
            f2=f2.next;
        }
        return head;
    }
}