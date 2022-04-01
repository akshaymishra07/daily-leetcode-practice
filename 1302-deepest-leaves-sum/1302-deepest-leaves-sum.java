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
    
   static int getMaxDepth(TreeNode root){
        
        if(root == null){
            return 0;
        }
       
       return 1+ Math.max(getMaxDepth(root.left),getMaxDepth(root.right));
    }
    
    static int ans = 0;
    
    static void deepestLeaves(TreeNode root, int depth, int maxDepth){
        
         if(root == null) return;
        
        if(depth == maxDepth){
            ans += root.val;
            return;
        }
        
        deepestLeaves(root.left,depth+1,maxDepth);
        deepestLeaves(root.right,depth+1,maxDepth);
        
    }
    
    public int deepestLeavesSum(TreeNode root) {
         
        ans = 0;
        
        int maxDepth = getMaxDepth(root);
        
        if(root == null) return 0;
        
        deepestLeaves(root, 1, maxDepth);
        
        return ans;
        
    }
}