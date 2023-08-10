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
     public TreeNode cons(int post[],int ps,int pe,int in[],int is,int ie){
         if(ps>pe || is>ie)return null;
        TreeNode root=new TreeNode(post[pe]);
        int count=0;
        int i=is;
        while(true){
            if(root.val==in[i]){
                break;
            }
            i++;
            count++;
           
        }
         root.left=cons(post,ps,ps+count-1,in,is,i-1);
         root.right=cons(post,ps+count,pe-1,in,i+1,ie);
         return root;
     }
    public TreeNode buildTree(int[] in, int[] post) {
         return cons(post,0,post.length-1,in,0,in.length-1);
    }
}