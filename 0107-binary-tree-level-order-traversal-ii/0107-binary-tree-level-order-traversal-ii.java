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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
            Queue<TreeNode> q=new LinkedList<>();
            if(root==null)return ans;
            q.add(root);
        while(q.size()>0){
            int s=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            while(s-- >0){
                TreeNode newnode=q.remove();
                list.add(newnode.val);
                if(newnode.left!=null){
                    q.add(newnode.left);
                }
                if(newnode.right!=null){
                    q.add(newnode.right);
                }
                
            }
            ans.add(0,list);
        }
        return ans;
        
    }
}