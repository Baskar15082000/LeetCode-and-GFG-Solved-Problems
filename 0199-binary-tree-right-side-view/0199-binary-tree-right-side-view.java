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
    public List<Integer> rightSideView(TreeNode node) {
      
        ArrayList<Integer> list=new ArrayList<>();
          if(node==null){
              return list;
          }
		Queue<TreeNode> q=new ArrayDeque<>();
		q.add(node);
		while(q.size()>0){
			int size=q.size();
			int rnode=0;
			while(size>0){
				TreeNode newnode=q.remove();
				rnode=newnode.val;
				if(newnode.left!=null){
					q.add(newnode.left);
				}
				if(newnode.right!=null){
					q.add(newnode.right);
				}
				
				size--;
			}
			list.add(rnode);
		}
		return list;
    }
}