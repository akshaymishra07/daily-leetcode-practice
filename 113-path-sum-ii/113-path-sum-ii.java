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
    
    public void solve(TreeNode root, List<Integer> temp, int sum, List<List<Integer>> res){
        
        if(root == null){
            return;
        }
        
        temp.add(root.val);
        
        if(root.left == null && root.right == null && root.val == sum){
            List<Integer> li = new ArrayList<>();
            
            for(int num : temp){
                li.add(num);
            }
            
            res.add(li);
        }
        
        solve(root.left, temp, sum - root.val, res);
        solve(root.right, temp, sum - root.val, res);
        
        temp.remove(temp.size()-1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(root, temp, targetSum, res);
        
        return res;
    }
}