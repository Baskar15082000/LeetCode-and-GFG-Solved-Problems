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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new ArrayDeque<>();
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null )return root.val;
        int ans=0;
        q.add(root);
        while(q.size()>0){
            int s=q.size();
            
            while(s-- > 0){
                TreeNode newnode=q.remove();
                list.add(newnode.val);
                if(newnode.left!=null){
                    q.add(newnode.left);
                }
                 if(newnode.right!=null){
                    q.add(newnode.right);
                }
                
            }
            ans=list.get(0);
            list.clear();
        }
        return ans;
    }
}