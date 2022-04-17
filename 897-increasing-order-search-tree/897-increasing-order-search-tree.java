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
    static TreeNode curr;
    static void traverse(TreeNode root){
        
        if(root == null){
            return;
        }
        
        traverse(root.left);
        root.left = null;
        curr.right=root;
        curr = root;
        traverse(root.right);
        
    }
    
    public TreeNode increasingBST(TreeNode root) {
        
        TreeNode ans = new TreeNode(0);
        curr = ans;
        traverse(root);
        
        return ans.right;
        
        
        
        
    }
}