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
    
    static int ans;
    
    static void getMinHeight(TreeNode root, int depth){
        
        if(root == null){
            return;
        }
        
        if(root.left  == null && root.right == null){
            ans = Math.min(ans,depth);
        }
        
        getMinHeight(root.left, depth+1);
        getMinHeight(root.right, depth+1);
    }
    
    public int minDepth(TreeNode root) {
        
        
        
        ans = Integer.MAX_VALUE;
        
        if(root == null){
            return 0;
        }
        
        getMinHeight(root,1);
        return ans;
    }
}