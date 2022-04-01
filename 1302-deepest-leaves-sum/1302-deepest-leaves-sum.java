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
    
    static int maximumSoFar = 1;
    int sum = 0;
    
    void calculateSum(TreeNode root, int level){
        
        if(root == null){
            return;
        }
        
         if(level > maximumSoFar){
            maximumSoFar = level;
            sum = 0;
        }
        
        if(level == maximumSoFar){
            sum += root.val;
        }
        
        calculateSum(root.left, level+1); 
        calculateSum(root.right, level+1);        

        
        
    }
    
    public int deepestLeavesSum(TreeNode root) {
        sum = 0;
        maximumSoFar = 1;
        if(root == null) return 0;
        calculateSum(root, 1);
        return sum;
        
       
    }
}