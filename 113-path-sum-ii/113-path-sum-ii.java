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
    
    public void solve(TreeNode root, int sum, List<Integer> path,  List<List<Integer>> ans){
        
        if(root == null){
            
            return;
        }
    
        sum = sum - root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null && sum == 0){
    
           List<Integer> temp = new ArrayList<>(); 
            
            for(int num : path){
                 temp.add(num);
            }
            
            ans.add(temp);
        }
     
        
        solve(root.left,  sum, path, ans);
        solve(root.right, sum, path, ans);
        
        path.remove(path.size()-1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        
        solve(root, targetSum, path,  ans);
        
        return ans;
    }
}