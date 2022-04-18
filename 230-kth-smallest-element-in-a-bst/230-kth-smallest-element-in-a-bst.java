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
    
    static void traverse(TreeNode root, int[] count, int k, int[] ans){
        
        
        if(root == null)return;
        
        
        
        traverse(root.left, count, k , ans);
        
        if(count[0]++ == k){
            ans[0] = root.val;
            return;
        }
        traverse(root.right, count, k, ans);
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
       
       int ans[] = new int[1]; 
       int count[] = new int[1];
       count[0] = 1; 
       traverse(root, count, k, ans);
       return ans[0]; 
        
    }
}