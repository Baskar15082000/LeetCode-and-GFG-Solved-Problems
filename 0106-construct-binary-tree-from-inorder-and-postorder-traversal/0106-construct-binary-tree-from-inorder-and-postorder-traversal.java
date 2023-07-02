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
    public TreeNode cons(int po[],int post,int poend,int in[],int inst,int inend){
		if(post>poend || inst>inend){
			return null;
		}
		TreeNode root=new TreeNode(po[poend]);
		int i=inst;
		int count=0;
		while(true){
			if(root.val==in[i]){
				break;
			}
			i++;
			count++;
		}
		root.left=cons(po,post,post+count-1,in,inst,i-1);
	    root.right=cons(po,post+count,poend-1,in,i+1,inend);
		return root;
	}
    public TreeNode buildTree(int[] inorder, int[] post) {
        int n=post.length;
        return cons(post,0,n-1,inorder,0,n-1);
    }
}