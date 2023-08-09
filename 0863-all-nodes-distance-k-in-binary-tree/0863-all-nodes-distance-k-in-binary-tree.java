/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parent(HashMap<TreeNode,TreeNode> parent,TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeNode t=q.remove();
            if(t.left!=null){
                parent.put(t.left,t);
                q.add(t.left);
            }
            if(t.right!=null){
                parent.put(t.right,t);
                q.add(t.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        parent(parent,root);
        
        HashSet<TreeNode> vis=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        vis.add(target);
        int c=0;
        while(q.size()>0){
            int s=q.size();
            if(c==k)break;
            c++;
            while(s-- >0){
                TreeNode t=q.remove();
                if(t.left!=null && !vis.contains(t.left)){
                    q.add(t.left);
                    vis.add(t.left);
                }
                 if(t.right!=null && !vis.contains(t.right)){
                    q.add(t.right);
                    vis.add(t.right);
                }
                if(parent.get(t)!=null && !vis.contains(parent.get(t))){
                    q.add(parent.get(t));
                    vis.add(parent.get(t));
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(q.size()>0){
            ans.add(q.remove().val);
        }
        return ans;
        
    }
}