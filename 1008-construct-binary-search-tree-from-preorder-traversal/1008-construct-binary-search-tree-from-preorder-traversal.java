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
    
    static int i = 0;
    
    static TreeNode make(int[] pre, long ub){
        
        if(i == pre.length || pre[i] > ub){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[i++]);
        root.left = make(pre,root.val);
        root.right = make(pre,ub);
        
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return make(preorder, Long.MAX_VALUE);
    }
}