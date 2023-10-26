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
    public ListNode merge(ListNode a,ListNode b){
        if(a==null)return b;
        if(b==null)return a;
        ListNode newnode;
        if(a.val<b.val){
            newnode = a;
            newnode.next =merge(a.next,b);
        }
        else{
             newnode = b;
            newnode.next =merge(a,b.next);
        }
        return newnode;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1)return lists[0];
        if(lists.length==0)return null;
        
        int n=lists.length;
        
        ListNode newnode=merge(lists[0],lists[1]);
        for(int i=2;i<n;i++){
            newnode=merge(newnode,lists[i]);
        }
        return newnode;
    }
}