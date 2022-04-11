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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        Stack<Integer> st = new Stack<>();
        
        int level = 0;
        
        q.add(root);
        
        while(! q.isEmpty()){
            
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i = 1; i <= n; i++){
                
                TreeNode temp = q.poll();
                
                if(temp.left != null){
                    q.add(temp.left);
                }
                
                if(temp.right != null){
                    q.add(temp.right);
                }
                
                if(level % 2 == 0){
                    list.add(temp.val);
                }else{
                    st.push(temp.val);
                }
            }
            
            
            while(!st.empty()){
                
                list.add(st.pop());
                
            }
            
            result.add(list);
            
            level++;
        }
        
        return result;
    }
}