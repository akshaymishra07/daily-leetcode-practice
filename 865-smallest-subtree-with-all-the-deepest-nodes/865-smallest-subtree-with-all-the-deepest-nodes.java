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
    static int max;
    
    int traverse(TreeNode root, int level){
        
        if(root == null){
             max = Math.max(max, level);
             return level; 
        }
        
        int lh = traverse(root.left, level+1);
        int rh = traverse(root.right, level+1);
        
        if(lh == max && rh == max){
            curr = root;
        }
        
        return Math.max(lh,rh);
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        max = -1;
        traverse(root, 0);
        
        return curr;
        
    }
}