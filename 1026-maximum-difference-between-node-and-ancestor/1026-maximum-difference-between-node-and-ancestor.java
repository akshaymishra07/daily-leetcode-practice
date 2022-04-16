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
    static int ans = 0;
    static void traverse(TreeNode root, int max, int min){
        
        if(root == null){
            return;
        }
        
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        
        if(root.left == null && root.right == null){
            int temp = Math.abs(max - min);
            ans = Math.max(temp, ans);
        }
        
        traverse(root.left, max, min);
        traverse(root.right, max, min);
    }
    
    public int maxAncestorDiff(TreeNode root) {
     
        
        
     int max = Integer.MIN_VALUE;
     int min = Integer.MAX_VALUE;
      ans = 0;
        
      traverse(root, max, min);
        
       return ans; 
        
    }
}