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
     
    
    public List<Integer> inorderTraversal(TreeNode root) {
       
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
       
        if(root==null)return new ArrayList<>();
        while(true){
           if(root!=null){
               st.push(root);
               root=root.left;
           }
           else{
               if(st.size()==0)break;
               TreeNode curr=st.pop();
               list.add(curr.val);
               root=curr.right;
           }
            
        }
        return list;
    }
}