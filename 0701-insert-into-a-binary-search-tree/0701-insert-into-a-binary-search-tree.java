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
    public TreeNode insertIntoBST(TreeNode node, int key) {
         if(node==null){
            node=new TreeNode(key);
             return node;
        }
        if(node.val ==key){
            return node;
        }
        if(node.val>key){
            node.left=insertIntoBST(node.left,key);
        }
        else{
            node.right=insertIntoBST(node.right,key);
        }
        return node;
    }
}