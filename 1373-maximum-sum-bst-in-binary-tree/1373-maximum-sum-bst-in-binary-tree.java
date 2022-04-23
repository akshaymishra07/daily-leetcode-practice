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

class Quad{
    
    boolean isBst;
    long min;
    long max;
    int sum;
    Quad(boolean isBst, long min, long max, int sum){
        
        this.isBst = isBst;
        this.min= min;
        this.max = max;
        this.sum = sum;
    }
}

class Solution {
    
    static int ans = 0;
    
    static Quad investigate(TreeNode root){
        
        if(root == null){
            return new Quad(true, Long.MAX_VALUE, Long.MIN_VALUE, 0);
        }
        
        Quad lst = investigate(root.left);
        Quad rst = investigate(root.right);
        
        boolean isBst = lst.isBst && rst.isBst && (lst.max < root.val && root.val < rst.min);
        long min = Math.min(root.val, Math.min(lst.min, rst.min));
        long max = Math.max(root.val, Math.max(lst.max, rst.max));
        
        if(isBst){
            ans = Math.max(ans, root.val+lst.sum+rst.sum);
        }
        
        return new Quad(isBst,min,max,root.val+lst.sum+rst.sum);
    }
    
    public int maxSumBST(TreeNode root) {
        
        ans = 0;
        
         if(root == null){
            return 0;
        }
        
        investigate(root);
        
        return ans;
        
        
        
    }
}