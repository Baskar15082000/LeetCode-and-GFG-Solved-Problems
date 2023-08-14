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
    public TreeNode cons(int pre[],int in[],int l,int r){
        if(in[0]==pre.length){
            return null;
        }
        if(pre[in[0]]<l || pre[in[0]]>r){
            return null;
        }
        TreeNode root=new TreeNode(pre[in[0]]);
        in[0]++;
        root.left=cons(pre,in,l,root.val-1);
        root.right=cons(pre,in,root.val+1,r);
        return root;
    }
    public TreeNode bstFromPreorder(int[] pre) {
        int id[]=new int[1];
        id[0]=0;
        TreeNode root=cons(pre,id,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return root;
    }
}