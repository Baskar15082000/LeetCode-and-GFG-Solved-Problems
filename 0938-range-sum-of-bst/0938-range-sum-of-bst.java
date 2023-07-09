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
    int sum;
	Solution(){
		this.sum=0;
	}
    public int rangeSumBST(TreeNode node, int l, int r) {
        	if(node==null){
			return sum;
		}
		if(node.val>=l && node.val<=r){
			sum=sum+node.val;
		}
		rangeSumBST(node.left,l,r);
		rangeSumBST(node.right,l,r);
		return sum;
    }
}