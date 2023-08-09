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
    class pair {
        TreeNode node;
        int id;
        pair(TreeNode node,int id){
            this.node=node;
            this.id=id;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        int ans=-1;
        q.add(new pair(root,0));
        while(q.size()>0){
            int s=q.size();
            int f=0;
            int l=0;
            int min=q.peek().id;
            for(int i=0;i<s;i++){
                pair p=q.remove();
                int c=p.id-min;
                if(i==0){
                    f=c;
                }
                if(i==s-1)
                {
                    l=c;
                }
                if(p.node.left!=null){
                    q.add(new pair(p.node.left,c*2+1));
                }
                 if(p.node.right!=null){
                    q.add(new pair(p.node.right,c*2+2));
                }
            }
            ans=Math.max(ans,l-f+1);
        }
        return ans;
    }
}