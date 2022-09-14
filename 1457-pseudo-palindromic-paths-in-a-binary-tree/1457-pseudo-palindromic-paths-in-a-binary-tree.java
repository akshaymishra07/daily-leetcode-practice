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
    static int ans = 0;
    
    public void solve(TreeNode root, int[] arr){
        
        if(root == null){
            return;
        }
        
        arr[root.val]++;
        
        if(root.left == null && root.right == null){
        
                int countOdd = 0;
                for(int i = 0; i < 10; i++){
                    
                    if(arr[i] % 2 != 0){
                        countOdd++;
                    }
                   
                }
                
                if(countOdd <= 1){
    
                    ans++;
                }
        }
        
        solve(root.left, arr);
        solve(root.right, arr);
        
        arr[root.val]--;
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        
        ans = 0;
        int[] arr = new int[10];
        
        solve(root, arr);
        
        return ans;
    }
}