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

class HeightPerfectPair{
    
    boolean isPerfect;
    int height;
    
    HeightPerfectPair(boolean isPerfect, int height){
        this.isPerfect = isPerfect;
        this.height = height;
    }
    
}

class Solution {
    
    static HeightPerfectPair isPerfect(TreeNode root){
        
        TreeNode temp = root;
        int lh = 0;
        
        while(temp != null){
            lh++;
            temp = temp.left;
        }
        
        temp = root;
        int rh = 0;
        
        while(temp != null){
            rh++;
            temp = temp.right;
        }
       
        return new HeightPerfectPair(lh == rh, lh);
        
    }
    
    public int countNodes(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int count = 1;
        
        HeightPerfectPair pleft = isPerfect(root.left);
        HeightPerfectPair pright = isPerfect(root.right);
         
        
        if(pleft.isPerfect){
            count += Math.pow(2,pleft.height)-1;
        }else{
            count += countNodes(root.left);
        }
        
        if(pright.isPerfect){
            count += Math.pow(2,pright.height)-1;
        }else{
            count += countNodes(root.right);
        }
        
        return count;
    }
}