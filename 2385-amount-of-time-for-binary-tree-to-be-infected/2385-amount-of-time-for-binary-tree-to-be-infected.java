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
        public TreeNode parent(HashMap<TreeNode,TreeNode> parent,TreeNode root,int start){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode node=null;
        while(q.size()>0){
            TreeNode t=q.remove();
            if(t.val==start){
                node=t;
            }
            if(t.left!=null){
                parent.put(t.left,t);
                q.add(t.left);
            }
            if(t.right!=null){
                parent.put(t.right,t);
                q.add(t.right);
            }
        }
            return node;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        TreeNode target= parent(parent,root,start);
        System.out.print(target.val);
        HashSet<TreeNode> vis=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        vis.add(target);
        int max=0;
        while(q.size()>0){
            int s=q.size();
            int fl=0;
            while(s-- >0){
                TreeNode t=q.remove();
                if(t.left!=null && !vis.contains(t.left)){
                    q.add(t.left);
                    vis.add(t.left);
                    fl=1;
                }
                if(t.right!=null && !vis.contains(t.right)){
                    q.add(t.right);
                    vis.add(t.right);
                     fl=1;
                }
                
                if(parent.get(t)!=null && !vis.contains(parent.get(t))){
                    q.add(parent.get(t));
                    vis.add(parent.get(t));
                    fl=1;
                }
            }
            if(fl==1){
                max++;
            }
        }
        return max;
       
   
    }
}