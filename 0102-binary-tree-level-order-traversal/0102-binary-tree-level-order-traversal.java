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
    public List<List<Integer>> levelOrder(TreeNode node) {
        	List<List<Integer>> ans=new ArrayList<>();
        if(node==null)return new ArrayList<>();
		Queue<TreeNode> q=new ArrayDeque<>();
		q.add(node);
		while(q.size()>0){
            int size=q.size();
            List<Integer> list =new ArrayList<>();
            while(size-- >0){
                TreeNode curr=q.remove();
                list.add( curr.val );
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                
            }
            ans.add(list);
        }
	return ans;
		
    }
}