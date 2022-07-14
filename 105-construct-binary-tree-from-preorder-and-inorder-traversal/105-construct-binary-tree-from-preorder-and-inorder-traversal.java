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
    
    TreeNode construct(int[] inorder, int[] preorder, int i1, int j1,int  i2, int j2, Map<Integer, Integer>map){
        
        if(i1 > j1){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i1]);
        int i = map.get(preorder[i1]);
                                                   //pre           //in
        root.left  = construct(inorder, preorder, i1+1, i1+i-i2,  i2, i-1, map);
        root.right = construct(inorder, preorder, i1+i-i2+1, j1,  i+1, j2, map);
     
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map  = new HashMap<>();
      
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
          
        TreeNode root = construct(inorder, preorder, 0, preorder.length-1, 0, inorder.length-1, map);
        
        return root;
    }
}