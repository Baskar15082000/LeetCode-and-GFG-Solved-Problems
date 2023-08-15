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
    private TreeNode pre=null,first=null,middle=null,last=null;
    public void find(TreeNode root){
        if(root==null)return;
        find(root.left);
        if(pre!=null && root.val<pre.val){
            if(first==null){
                first=pre;
                middle=root;
            }
            else{
                last=root;
            }
        }
        pre=root;
        find(root.right);
    }
    public void recoverTree(TreeNode root) {
        
        pre=new TreeNode(Integer.MIN_VALUE);
        find(root);
        if(first!=null && last!=null){
            int t=first.val;
            first.val=last.val;
            last.val=t;
        }
        else if(first!=null && middle!=null){
            int t=first.val;
            first.val=middle.val;
            middle.val=t;
        }
    }
}