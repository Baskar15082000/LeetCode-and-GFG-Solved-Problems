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
    public TreeNode cons(int pre[],int prest,int preend,int in[],int inst,int inend){
        if(prest>preend||inst>inend){
            return null;
        }
        TreeNode root=new TreeNode(pre[prest]);
        int i=inst;
        int count=0;
        while(true){
            if(root.val==in[i]){
                break;
            }
            i++;
            count++;
        }
        root.left=cons(pre,prest+1,prest+count,in,inst,i-1);
        root.right=cons(pre,prest+count+1,preend,in,i+1,inend);
        return root;
    }
    public TreeNode buildTree(int[] pre, int[] in) {
        return cons(pre,0,pre.length-1,in,0,in.length-1);
    }
}