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
    
    static TreeNode construct(int[] pre, int[] in, int i1 , int j1, int i2 , int j2, Map<Integer, Integer> map){
        
        if(i1 > j1){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[i1]);
        
        int i = map.get(pre[i1]);
        
        int numsLeft = i - i2;
        
        root.left = construct(pre, in, i1+1, i1+numsLeft, i2 , i-1,map);
        root.right = construct(pre, in, i1+numsLeft+1, j1, i+1 , j2,map);
        
        return root;
        
    }
    
    public TreeNode buildTree(int[] pre, int[] in) {
        
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < in.length; i++){
            map.put(in[i] , i);
        }
        
        TreeNode ans = construct(pre,in,0,pre.length-1,0,in.length-1,map);
        
        return ans;
    }
}