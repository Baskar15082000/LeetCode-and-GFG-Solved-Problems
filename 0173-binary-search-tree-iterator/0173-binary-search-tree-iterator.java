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
class BSTIterator {
    private Stack<TreeNode> st=new Stack<>();

    public BSTIterator(TreeNode root) {
       push(root);
    }
    
    public int next() {
        TreeNode newnode=st.pop();
        push(newnode.right);
        return newnode.val;
    }
    
    public boolean hasNext() {
        return st.size()!=0;
    }
    public void push(TreeNode root){
         while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */