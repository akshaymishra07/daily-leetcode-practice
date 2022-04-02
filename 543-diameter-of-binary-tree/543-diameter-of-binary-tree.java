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
    
    static int getHeight(TreeNode root, int[] ans){
        
        if(root == null){
            return 0;
        }
        
        int lh = getHeight(root.left, ans);
        int rh = getHeight(root.right, ans);
        
        ans[0] = Math.max(ans[0], 1+lh+rh);
        
        return 1 + Math.max(lh,rh);
    } 
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        } 
       
        int ans[] = new int[1];
        
        getHeight(root, ans);
        
        return ans[0]-1;
       
    }
}