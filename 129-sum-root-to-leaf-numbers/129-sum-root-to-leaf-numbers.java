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
    
     static void helper(TreeNode root, String str , ArrayList<Integer> res){

         if(root == null){
            return;
         }
         
         str += root.val;
         if(root.left == null && root.right == null){
            int num = Integer.parseInt(str);
            res.add(num); 
         }

         helper(root.left,str,res);
         helper(root.right,str,res);

         str = str.substring(0,str.length()-1); 
 
    }
    
    public int sumNumbers(TreeNode root) {
     
        ArrayList<Integer> res = new ArrayList<>();
        helper(root,"",res);

        int sum = 0;

        for(int n : res){
            sum += n;
        }
        
        return sum;
    }
}