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
    
    public static int sum = 0;
    
    public static void sumLeft(TreeNode root, boolean flag){
        
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null && flag){
            
            sum += root.val;
        }
        
        sumLeft(root.left,true);
        sumLeft(root.right, false);
        
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
         sum = 0;
        sumLeft(root, false);
      
        return sum;
    }
}