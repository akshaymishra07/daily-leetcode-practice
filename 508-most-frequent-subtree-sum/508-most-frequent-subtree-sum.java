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
    
    static HashMap<Integer, Integer> sums = new HashMap<>();
     
    static int frequentSums(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        int sum = root.val;
        
        if(root.left != null){
            sum += frequentSums(root.left);
        }
        
        if(root.right != null){
            sum += frequentSums(root.right);
        }
        
        sums.put(sum, sums.getOrDefault(sum, 0)+1);
        return sum;
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        sums = new HashMap<>();
        frequentSums(root);
        
        int max = 0;
        List<Integer> res = new ArrayList<Integer>();
        
        for(Map.Entry entry : sums.entrySet()){
            
            max = Math.max(max, (int)entry.getValue());
            
        }
        
         for(Map.Entry entry : sums.entrySet()){
            
            if((int)entry.getValue() == max){
                res.add((int)entry.getKey());
            }
            
        }
        
        
        int[] arr =  new int[res.size()];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = res.get(i);
        }
        
        return arr; 
    }
}