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
    static int goodNodes;
    
     void traverse(TreeNode root, int maxSoFar){
         
         if(root == null){
             return;
         }
         
         if(root.val >= maxSoFar){
             goodNodes++;
         }
         
         maxSoFar = Math.max(maxSoFar, root.val);
         
         traverse(root.left, maxSoFar);
         traverse(root.right, maxSoFar);
         
     }
    
    
    public int goodNodes(TreeNode root) {
        goodNodes = 0;
        
        traverse(root, Integer.MIN_VALUE);
        
        return goodNodes;
    }
}