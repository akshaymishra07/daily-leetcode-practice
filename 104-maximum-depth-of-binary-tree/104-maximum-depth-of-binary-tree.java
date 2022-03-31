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
    static int ans = 0;
    
    static void getMaxDepth(TreeNode root, int depth){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            ans = Math.max(ans,depth);
            return;
        }
        
        getMaxDepth(root.left, depth+1);
        getMaxDepth(root.right, depth+1);
    }
    
    public int maxDepth(TreeNode root) {
       
          ans = 0;
        
            getMaxDepth(root,1);
        
          return ans;
        
        
    }
}