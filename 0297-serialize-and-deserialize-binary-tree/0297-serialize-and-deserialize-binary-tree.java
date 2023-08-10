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
    public String serialize(TreeNode root) {
        if(root==null)return "null";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeNode p=q.remove();
            if(p==null){
                sb.append("null,");
                continue;
            }
            sb.append(""+p.val+",");
            q.add(p.left);
            q.add(p.right);
            
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if(data.equals("null"))return null;
         String str[]=data.split(",");
         TreeNode root=new TreeNode(Integer.parseInt(str[0]));
         Queue<TreeNode> q=new LinkedList<>();
         q.add(root);
        for(int i=1;i<str.length;i++){
            TreeNode p=q.remove();
            if(!str[i].equals("null")){
                TreeNode l=new TreeNode(Integer.parseInt(str[i]));
                p.left=l;
                q.add(l);
            }
             if(!str[++i].equals("null")){
                TreeNode r=new TreeNode(Integer.parseInt(str[i]));
                p.right=r;
                 q.add(r);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));