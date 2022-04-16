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
   
    static void traverse(TreeNode root, List<Integer> temp, int currentSum, int sum,  List<List<Integer>> result){
        
        if(root == null){
            return;
        }
        
        temp.add(root.val);
        currentSum += root.val;
        
        if(root.left == null && root.right == null){
          
            if(currentSum == sum){
                
                List<Integer> li = new ArrayList<>();
                
                for(int num : temp){
                    li.add(num);
                }
                
                result.add(li);
            }
            
        }
        
        traverse(root.left, temp, currentSum, sum, result);
        traverse(root.right, temp, currentSum, sum, result);
     
        currentSum -= temp.get(temp.size()-1);
        temp.remove(temp.size()-1);
        
    
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        traverse(root,temp,0,targetSum, result);
        
        return result;
    }
}