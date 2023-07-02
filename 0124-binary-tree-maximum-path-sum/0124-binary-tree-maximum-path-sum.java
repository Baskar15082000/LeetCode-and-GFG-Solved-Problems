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
    public int max(TreeNode node ,int arr[]){
        if(node==null){
            return 0;
        }
        int l=max(node.left,arr);
        int r=max(node.right,arr);
        int max_single = Math.max(Math.max(l, r) + node.val, node.val);
          int max_top = Math.max(max_single, l + r + node.val);
        arr[0]=Math.max(arr[0],max_top);
        return max_single;
    }
    public int maxPathSum(TreeNode root) {
        int arr[]=new int [1];
        arr[0]=-Integer.MIN_VALUE;
        max(root , arr);
        return arr[0];
    }
}