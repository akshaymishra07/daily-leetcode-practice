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
    
    static int getHeight(TreeNode root, boolean[] ans){
        
        if(root == null){
            return 0;
        }
        int lh = getHeight(root.left,ans);
        int rh = getHeight(root.right,ans);
        
        if(Math.abs(lh-rh) > 1){
            ans[0] = false;
        }
        
        return 1 + Math.max(lh,rh);
    }
    
    public boolean isBalanced(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        boolean ans[] = new boolean[1];
        ans[0] = true;
        getHeight(root, ans);
        
        return ans[0];
    }
}