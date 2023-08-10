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
    public int left(TreeNode root){
        int count=0;
        while(root.left!=null){
            
            count++;
            root=root.left;
        }
        return count;
    }
    public int right(TreeNode root){
         int count=0;
        while(root.right!=null){
            
            count++;
            root=root.right;
        }
        return count;
    }    
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int l=left(root);
        int r=right(root);
        if(l==r){
            return (2<<l)-1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
        
    }
}