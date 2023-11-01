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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)return 0;
        int arr[]=new int[1];
        dfs(root,arr);
        return arr[0];
    }
     int dfs(TreeNode root,int arr[]){
        if(root==null){
            return 0;
        }
        int l =dfs(root.left,arr);
        int r =dfs(root.right,arr);
        int t1=0;
        int t2=0;
        if(root.left!=null && root.left.val==root.val){
            t1=l+1;
        }
        if(root.right!=null && root.right.val==root.val){
            t2=r+1;
        }
        arr[0]=Math.max(arr[0],t1+t2);
        return Math.max(t1,t2);
    }
}