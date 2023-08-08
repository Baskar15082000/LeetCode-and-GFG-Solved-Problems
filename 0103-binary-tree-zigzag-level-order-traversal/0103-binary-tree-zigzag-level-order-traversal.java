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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int n=0;
        while(q.size()>0){
            int s =q.size();
            List<Integer> list=new ArrayList<>();
            while(s-- >0){
                TreeNode p=q.remove();
                list.add(p.val);
                if(p.left!=null){
                    q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
            }
            if(n%2==0){
                ans.add(list);
            }
            else{
                Collections.reverse(list);
                ans.add(list);
            }
            n++;
        }
        return ans;
    }
}