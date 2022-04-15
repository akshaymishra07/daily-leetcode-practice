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
    
    static boolean isIdentical(TreeNode r1, TreeNode r2){
       
        
        if(r1 == null && r2 == null){
            return true;
        }
        
        if(r1 == null || r2 == null){
            return false;
        }
        
        return r1.val == r2.val && isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
        
    }
    
    static void traverse(TreeNode r1, TreeNode r2, boolean[] ans){
        
        if(isIdentical(r1,r2)){
            ans[0] = true;
            return;
        }
        
        if(r1 == null){
            return;
        }
        
        traverse(r1.left,r2,ans);
        traverse(r1.right,r2,ans);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    
        boolean ans[] = new boolean[1];
        
        traverse(root,subRoot,ans);
        
        return ans[0];
    }
}