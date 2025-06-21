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
        //level order
        if(root == null)return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                sb.append("n" +" ");
                continue;
            }
            sb.append(curr.val+" ");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")return null;
        Queue<TreeNode> q = new LinkedList<>();
        String values[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i = 1;i<values.length;i++){
            TreeNode parent = q.remove();
            if(!values[i].equals("n")){
                TreeNode newLeft = new TreeNode(Integer.parseInt(values[i]));
                parent.left = newLeft;
                q.add(newLeft);
            }
            //if the next node is not null then append as a right node
            if(!values[++i].equals("n")){
                TreeNode newRight = new TreeNode(Integer.parseInt(values[i]));
                parent.right = newRight;
                q.add(newRight);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));