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
    static int maxLevelSoFar = -1;
    
    static void traverse(TreeNode root, int level, List<Integer> result){
        
        if(root == null){
            return;
        }
        
        if(level > maxLevelSoFar){
            
            result.add(root.val);
            maxLevelSoFar = level;
            
        }
        
        traverse(root.right, level+1, result);
        traverse(root.left, level+1, result);
        
    }
    
    
    public List<Integer> rightSideView(TreeNode root) {
          
        maxLevelSoFar = -1;
        List<Integer> result = new ArrayList<>();
        
        if(root == null)return result;
        
        traverse(root,0,result);
        
        return result;
    }
}