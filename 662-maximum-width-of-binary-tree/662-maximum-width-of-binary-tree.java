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
class Pair{
    TreeNode node;
    int id;
    
    Pair(TreeNode node, int id){
        this.node = node;
        this.id = id;
    }
    
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            
            int n = q.size();
            int min = q.peek().id;
            int first = 0;
            int last = 0;
            int i = 0;
            while(i < n){
              int currentIndex = q.peek().id - min;
               TreeNode temp = q.poll().node; 
              if(i == n-1){
                  last = currentIndex;
              }
              if(i == 0){
                  first = currentIndex;
              }  
                
              if(temp.left != null)q.add(new Pair(temp.left, 2*currentIndex+1));
              if(temp.right != null)q.add(new Pair(temp.right, 2*currentIndex+2));  
              
              i++;  
            }
            
            
            ans = Math.max(ans, last-first+1);
            
        }
        
        return ans;
    }
}