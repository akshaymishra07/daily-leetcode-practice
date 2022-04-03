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
    
    Pair<Integer, Integer> getMaxPath(TreeNode root){
        
        if(root == null){
            return new Pair<Integer, Integer> (Integer.MIN_VALUE,  0);
        }
        
        
        Pair<Integer, Integer> lst = getMaxPath(root.left);
        Pair<Integer, Integer> rst = getMaxPath(root.right);
        
        int maxSumPath = Math.max(root.val+Math.max(lst.getValue(),0)+Math.max(rst.getValue(),0), Math.max(lst.getKey(),rst.getKey()));
        
        int maxUniPath = root.val + Math.max(0, Math.max(lst.getValue(), rst.getValue()));
        
        return new Pair<Integer, Integer>(maxSumPath, maxUniPath);
        
    }
    
    public int maxPathSum(TreeNode root) {
         
        
        Pair<Integer, Integer> res = getMaxPath(root);
        
        return res.getKey();
    }
}