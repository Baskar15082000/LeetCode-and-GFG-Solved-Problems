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
    public TreeNode cons(int pre[],int ps,int pe,int in[],int is,int ie){
        if(ps>pe || is>ie)return null;
        TreeNode root=new TreeNode(pre[ps]);
        int count=0;
        int i=is;
        while(true){
            if(root.val==in[i]){
                break;
            }
            i++;
            count++;
           
        }
         root.left=cons(pre,ps+1,ps+count,in,is,i-1);
         root.right=cons(pre,ps+count+1,pe,in,i+1,ie);
         return root;
    }
    public TreeNode buildTree(int[] pre, int[] in) {
        return cons(pre,0,pre.length-1,in,0,in.length-1);
    }
}