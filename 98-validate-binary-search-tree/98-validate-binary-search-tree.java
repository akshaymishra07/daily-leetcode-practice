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
    static void check(TreeNode root, long lb, long ub, boolean[] ans){
        
        if(root == null){
            return;
        }
        
        if(root.val <= lb || root.val >= ub){
            ans[0] = false;
            return;
        } 
        
        check(root.left, lb, root.val, ans);
        check(root.right, root.val, ub, ans);
        
    }
    public boolean isValidBST(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        boolean ans[] = new boolean[]{true};
        
        check(root, Long.MIN_VALUE, Long.MAX_VALUE,ans);
        
        return ans[0];
    }
}