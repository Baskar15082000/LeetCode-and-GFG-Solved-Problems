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
    public void help(TreeNode root,int count[],int ans[]){
        if(root==null)return;
        help(root.left,count,ans);
        count[0]--;
        if(count[0]==0){
            ans[0]=root.val;
            return;
        }
        help(root.right,count,ans);
        
    }
    public int kthSmallest(TreeNode root, int k) {
       int count[]=new int[1];
        count[0]=k;
        int ans[]=new int[1];
        help(root,count,ans);
        return ans[0];
            
    }
}