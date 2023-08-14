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
 *         this.left =    
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isbst(TreeNode root,long l,long r){
        if(root==null)return true;
        if(root.val<=l|| root.val>=r){
            return false;
        }
        return isbst(root.left,l,root.val) && isbst(root.right,root.val,r);
    }
    public boolean isValidBST(TreeNode root) {
        return isbst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}