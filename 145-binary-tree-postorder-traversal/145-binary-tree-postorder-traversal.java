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

class NodeFlagPair{
    TreeNode node;
    int flag;
    
   public NodeFlagPair(TreeNode node, int flag){
        this.flag = flag;
        this.node = node;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
         if(root == null){
            return new ArrayList<Integer>();
        }
        
        Stack<NodeFlagPair> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        st.push(new NodeFlagPair(root, 0));
        
        while(!st.empty()){
            
            NodeFlagPair pair = st.peek();
            st.pop();
            
            if(pair.flag == 1){
                result.add(pair.node.val);
            }else{
                
                 st.push(new NodeFlagPair(pair.node,1));
                
                if(pair.node.right != null){
                    st.push(new NodeFlagPair(pair.node.right,0));
                }
                
                if(pair.node.left != null){
                    st.push(new NodeFlagPair(pair.node.left,0));
                }
                
                
            }
            
        }
        return result;
    }
}