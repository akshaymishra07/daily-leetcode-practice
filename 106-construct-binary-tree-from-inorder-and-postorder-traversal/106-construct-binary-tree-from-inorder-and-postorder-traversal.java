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
    
    static TreeNode construct(int[] post, int[] in, int i1 , int j1, int i2 , int j2, Map<Integer, Integer> map){
        
        if(i1 > j1){
            return null;
        }
        
        TreeNode root = new TreeNode(post[j1]);
        
        int i = map.get(post[j1]);
        
        
        
        root.left = construct(post, in, i1, i1+i-i2-1, i2 , i-1,map);
        root.right = construct(post, in, i1+i-i2, j1-1, i+1 , j2,map);
        
        return root;
        
    }
    
    
    public TreeNode buildTree(int[] in, int[] post) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < in.length; i++){
            map.put(in[i] , i);
        }
        
        TreeNode ans = construct(post,in,0,post.length-1,0,in.length-1,map);
        
        return ans;
    }
}