/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public void pre(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("null,");
            return;
        }
        sb.append(""+node.val+",");
        pre(node.left,sb);
        pre(node.right,sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder("");
        pre(root ,sb);
        return sb.toString();
    }
    int i=0;
    public TreeNode cons(String []str){
        if(i>=str.length||str[i].equals("null")){
            i++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(str[i]));
        i++;
        root.left=cons(str);
        root.right=cons(str);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String str[]=data.split(",");
        return cons(str);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;