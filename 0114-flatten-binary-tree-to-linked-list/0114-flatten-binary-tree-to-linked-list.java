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
    public void flatten(TreeNode root) {
        if(root==null){
            return ;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=null;
        TreeNode cuur=root;
        while(cuur.right!=null){
            cuur=cuur.right;
        }
        cuur.right=temp;
    }
}