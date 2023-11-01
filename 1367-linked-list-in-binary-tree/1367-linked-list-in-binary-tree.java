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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null)return true;
        if(root==null)return false;
        
         return isSubPathFromRoot(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
//     boolean dfs(ListNode head, TreeNode root){
//         if(head==null)return true;
//         if(root==null)return false;
        
//         if(root.val!=head.val)return false;
//         return dfs(head.next,root.left)||dfs(head.next,root.right);
//     }
    
     private boolean isSubPathFromRoot(ListNode head, TreeNode root) {
        if (head == null) {
            return true; // We have reached the end of the linked list.
        }
        if (root == null || head.val != root.val) {
            return false; // Mismatch in values or no more nodes in the tree.
        }

        return isSubPathFromRoot(head.next, root.left) || isSubPathFromRoot(head.next, root.right);
    }
    
}