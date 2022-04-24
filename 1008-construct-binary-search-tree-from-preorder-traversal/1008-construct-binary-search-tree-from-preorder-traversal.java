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
    static int i;
    static TreeNode make(int[] pre, int key, long min, long max){
        
        if(i > pre.length-1){
            return null;
        }
        
        TreeNode root = null;
        
        if(key > min && key < max){
            
            root = new TreeNode(key);
            if(i+1 == pre.length){
                return root;
            }
            i++;
            
            root.left = make(pre,pre[i],min,key);
            root.right = make(pre,pre[i],key, max);
        }
        
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        
        return make(preorder, preorder[i], Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
}