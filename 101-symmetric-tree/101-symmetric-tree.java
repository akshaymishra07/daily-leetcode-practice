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
    static boolean isMirrorImage(TreeNode root1 , TreeNode root2){
        
        if(root1 == null && root2 == null){
            return true;
        }
        
        if(root1 == null || root2 == null){
            return false;
        }
        
        return root1.val == root2.val && isMirrorImage(root1.left, root2.right) && isMirrorImage(root1.right, root2.left);    
    }
    
    public boolean isSymmetric(TreeNode root) {
        
        return isMirrorImage(root.left, root.right);
    }
}