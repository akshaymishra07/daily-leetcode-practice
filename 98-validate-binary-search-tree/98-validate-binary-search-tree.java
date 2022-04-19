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
    
    static void traverse(TreeNode root, long[] prev, boolean[] ans){
        
        if(root == null) return;
        
        traverse(root.left, prev, ans);
        
        if(root.val <= prev[0]){
            ans[0] = false;
            return;
        }
        
        prev[0] = root.val;
        
        traverse(root.right, prev,ans);
    }
    
    public boolean isValidBST(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            return true;
        }
        
        long[] prev = new long[1];
        boolean[] ans = new boolean[1];
        
        prev[0] = Long.MIN_VALUE; 
        ans[0] = true;
        traverse(root, prev, ans);
        
        return ans[0];
    }
}