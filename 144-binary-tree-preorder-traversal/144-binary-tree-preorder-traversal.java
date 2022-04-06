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
    
    static void preOrder(TreeNode root, List<Integer> nodes){
      
        if(root == null){
            return;
        } 
        
        nodes.add(root.val);
        preOrder(root.left,nodes);
        preOrder(root.right,nodes);
        
        
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        
        preOrder(root,nodes);
        
        return nodes;
    }
}