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
class Triplet{
    
    boolean isBst;
    long min;
    long max;
    
    Triplet(boolean isBst, long min, long max){
        
        this.isBst = isBst;
        this.min= min;
        this.max = max;
        
    }
}
class Solution {
    
    static Triplet investigate(TreeNode root){
        
        if(root == null){
            return new Triplet(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }
        
        Triplet lst = investigate(root.left);
        Triplet rst = investigate(root.right);
        
        boolean isBst = lst.isBst && rst.isBst && (lst.max < root.val && root.val < rst.min);
        long min = Math.min(root.val, Math.min(lst.min, rst.min));
        long max = Math.max(root.val, Math.max(lst.max, rst.max));
        
        return new Triplet(isBst,min,max);
    }
    
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)return true;
        
        Triplet result = investigate(root);
        
        return result.isBst;
    }
}