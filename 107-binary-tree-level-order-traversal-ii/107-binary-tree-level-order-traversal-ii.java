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
    
    static void reverse(List<List<Integer>> list){
        
        int start = 0;
        int end = list.size()-1;
        
        while(start < end){
            
            List<Integer> temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end , temp);
            
            start++;
            end--;
        }
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
          List<List<Integer>> res = new ArrayList<>();
        
          if(root == null){
              return res;
          }
          
          Queue<TreeNode> q = new LinkedList<>();
          
        
         
          q.add(root);
        
          while(!q.isEmpty()){
              
              int n = q.size();
              List<Integer> li = new ArrayList<>();
              while(n-- > 0){
                
                TreeNode temp = q.poll();
                
                if(temp.left != null){
                    q.add(temp.left);
                }
                  
                if(temp.right != null){
                    q.add(temp.right);
                }   
                 
                li.add(temp.val);   
             } 
              
             res.add(li); 
          }
        
        reverse(res);
        
        return res;
    }
}