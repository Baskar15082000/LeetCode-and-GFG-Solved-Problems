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
    
    class pair{
    int sum;
    int max;
    int min;
    boolean isbst;
    pair(int sum,int min,int max,boolean isbst){
        this.sum=sum;
        this.min=min;
        this.max=max;
        this.isbst=isbst;
    }
}

    
    public int maxSumBST(TreeNode root) {
         dfs(root);
        return ans;
    }
    int ans=0;
    pair dfs(TreeNode root){
        if(root==null)return new pair(0,Integer.MAX_VALUE,Integer.MIN_VALUE,true);
        pair l=dfs(root.left);
        pair r=dfs(root.right);
        if(l.isbst && r.isbst && root.val>l.max && root.val<r.min){
            int sum = r.sum+l.sum+root.val;
            int min = Math.min(root.val,l.min);
            int max = Math.max(root.val,r.max);
            
            ans=Math.max(ans,sum);    
            return new pair(sum,min,max,true);
        }
        
        return new pair(Math.max(l.sum, r.sum), 0, 0, false);
   
        
    }
    
}