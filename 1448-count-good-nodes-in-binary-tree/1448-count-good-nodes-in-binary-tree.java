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
    static int count = 0;
    
    static void traverse(TreeNode root, long maxSoFar){
        
        if(root == null){
            return;
        }
        
        if(root.val >= maxSoFar){
            count++;
        }
        
        maxSoFar = Math.max(root.val, maxSoFar);
        
        traverse(root.left , maxSoFar);
        traverse(root.right, maxSoFar);
        
        
        
    }
    
    
    public int goodNodes(TreeNode root) {
        
        count = 0;
        
        traverse(root, Long.MIN_VALUE);
        
        return count;
        
    }
}