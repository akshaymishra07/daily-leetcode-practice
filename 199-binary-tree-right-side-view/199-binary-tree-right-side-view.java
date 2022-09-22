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
    
    static int maxLevel = -1; 
    
    public void traverse(TreeNode root, int level, List<Integer> ans){
        
        if(root == null) {
            return;
        }
        
        if(level > maxLevel){
            maxLevel = level;
            ans.add(root.val);
        }
        
        traverse(root.right, level+1, ans);
        traverse(root.left, level+1, ans);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        
        maxLevel = -1;
        List<Integer> ans = new ArrayList<>();
        traverse(root, 0, ans);
        
        return ans;
    }
}