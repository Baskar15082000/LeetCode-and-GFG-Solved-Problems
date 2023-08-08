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
    public int dfs(int arr[],TreeNode root){
        if(root==null)return 0;
        int l=dfs(arr,root.left);
        int r=dfs(arr,root.right);
        arr[0]=Math.max(arr[0],l+r);
        return 1 + Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int arr[]=new int[1];
        dfs(arr,root);
        return arr[0];
    }
}