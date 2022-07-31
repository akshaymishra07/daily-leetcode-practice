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
    
    void solve(TreeNode root, int level, List<Integer> li){
        
        if(root == null){
            return;
        }
        
        if(level > maxLevel){
            li.add(root.val);
            maxLevel = level;
        }
        
        solve(root.right, level+1, li);
        solve(root.left, level+1, li);
        
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        maxLevel = -1;
        
        List<Integer> li = new ArrayList<>();
        
        solve(root, 0,  li);
        
        return li;
    }
}