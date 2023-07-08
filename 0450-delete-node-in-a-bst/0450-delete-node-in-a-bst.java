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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val>key){
            TreeNode l=deleteNode(root.left,key);
            root.left=l;
        }
        else if(root.val<key){
            TreeNode r=deleteNode(root.right,key);
            root.right=r;
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.right!=null && root.left==null){
                return root.right;
            }
            else if(root.left!=null && root.right==null){
                return root.left;
            }
            else{
                int min=min(root.right);
                root.val=min;
                root.right=deleteNode(root.right,min);
            }
        }
        return root;
    }
    public int min(TreeNode node){
        if(node.left==null)return node.val;
        return min(node.left);
    }
}