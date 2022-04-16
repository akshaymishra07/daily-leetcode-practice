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
    public int findBottomLeftValue(TreeNode root) {
     
        Queue<TreeNode> q = new LinkedList<>();
        int ele = 0;
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode temp = q.poll();
            
            ele = temp.val;
            
            if(temp.right != null){
                q.add(temp.right);
            }
            
            if(temp.left != null){
                q.add(temp.left);
            }
            
        }
        
        return ele;
    }
}