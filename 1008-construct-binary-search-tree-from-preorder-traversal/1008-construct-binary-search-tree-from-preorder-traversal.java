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
    int id=0;
    public TreeNode cons(int []pre,int l, int r){
        if(pre.length==id)return null;
        if(pre[id]<l || pre[id]>r)
            return null;
        TreeNode node =new TreeNode(pre[id]);
        id++;
        node.left=cons(pre,l,node.val-1);
        node.right=cons(pre,node.val+1,r);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return cons(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}