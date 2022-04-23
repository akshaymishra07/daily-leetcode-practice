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
    
    static int[] nextGreaterElement(int[] arr){
        int n = arr.length;
        int[] nge = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                nge[st.pop()] = i;
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()){
            nge[st.pop()] = n;
        }
        
        return nge;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        if(preorder.length == 0){
            return null;
        }
        int[] nge = nextGreaterElement(preorder);
        
        
        
        return make(preorder,0,preorder.length-1,nge);
    }
    
    static TreeNode make(int[] pre, int i, int j, int[] nge){
        
        if(i > j){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[i]);
        
        root.left = make(pre,i+1,nge[i]-1,nge);
        root.right = make(pre,nge[i],j,nge);
        
        return root;
    }
}