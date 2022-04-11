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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        st.push(root);
        
        while(!st.empty()){
            
            TreeNode curr = st.pop();
            result.add(curr.val);
            if(curr.right != null){
              st.push(curr.right);
            }
            
            if(curr.left != null){
              st.push(curr.left);
            }
            
            
        }
        return result;
    }
}