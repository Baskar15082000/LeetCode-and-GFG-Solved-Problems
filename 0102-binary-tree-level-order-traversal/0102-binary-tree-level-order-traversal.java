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
            ArrayList<Integer> list=new ArrayList<>();
			int size=q.size();
			while(size>0){
				TreeNode newnode=q.remove();
				if(newnode.left!=null){
					q.add(newnode.left);
				}
				if(newnode.right!=null){
					q.add(newnode.right);
				}
				list.add(newnode.val);
				size--;
			}
            ans.add(list);
		}
		return ans;
		
    }
}