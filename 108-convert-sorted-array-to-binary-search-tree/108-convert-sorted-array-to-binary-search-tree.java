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
    
    static TreeNode create(int i, int j, int[] nums){
        
        if(i > j){
            return null;
        }
        
        int mid = (i+j)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = create(i,mid-1,nums);
        root.right= create(mid+1, j, nums);
        
        return root;
        
        
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
       TreeNode root =   create(0,nums.length-1, nums);
        return root;
    }
}