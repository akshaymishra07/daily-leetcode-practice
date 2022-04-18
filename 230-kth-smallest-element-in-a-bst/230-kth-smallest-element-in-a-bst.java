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
    
    static void traverse(TreeNode root, List<Integer> res){
        
        
        if(root == null)return;
        
        traverse(root.left, res);
        
        res.add(root.val);
        
        traverse(root.right, res);
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
       List<Integer> res = new ArrayList<>();  
       
       traverse(root, res);
        
       return res.get(k-1); 
        
    }
}