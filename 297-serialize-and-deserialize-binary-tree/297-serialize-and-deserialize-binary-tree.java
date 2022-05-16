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
        
        if(root == null) return "";
        
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        
        while(!q.isEmpty()){
            
           TreeNode curr = q.poll();
            
           if(curr == null){
               sb.append("#,");
               continue;
           }else
               sb.append(Integer.toString(curr.val)+",");
            
           q.add(curr.left);
           q.add(curr.right); 
        }
        String result = sb.toString();
     
        return result.substring(0,result.length());
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        
        if(data.equals("")) return null;
        
        String[] nodes = data.split(",");
        int i = 1;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode curr = q.poll();
            
            
            if(!nodes[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i++]));
                curr.left = left;
                q.add(left);
            }else i++;
            
            if(!nodes[i].equals("#")){
                 TreeNode right = new TreeNode(Integer.parseInt(nodes[i++]));
                 curr.right = right;
                 q.add(right);
            }else i++;
        
        } 
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));