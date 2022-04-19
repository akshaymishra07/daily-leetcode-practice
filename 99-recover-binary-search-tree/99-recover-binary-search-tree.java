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
    
    static TreeNode prev;
    static TreeNode one;
    static TreeNode two;   
    
    
    static void traverse(TreeNode root){
        if(root == null)return;
        
        traverse(root.left);
        
        if(prev != null && prev.val > root.val){
            
            if(one == null) one = prev;
            
            two = root;
        }
        
        prev = root;
        traverse(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        prev = null;
        one = null;
        two = null;
        
        traverse(root);
        
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }
}