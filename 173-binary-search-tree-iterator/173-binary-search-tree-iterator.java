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
class BSTIterator {
    
    ArrayList<Integer> list;
    int i;
    public BSTIterator(TreeNode root) {
    
        list = new ArrayList<>();
        i = -1;
        
        inorder(root, list);
        
        System.out.println(list.toString());
    }
    
    static void inorder(TreeNode root, ArrayList<Integer> list){
        
        if(root == null){
            return;
        }
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    } 
    
    public int next() {
        
        if(i < list.size()){
            return list.get(++i);
        }
        
        return -1;
    }
    
    public boolean hasNext() {
        
        return !(i == list.size()-1);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/*class BSTIterator {
    
    TreeNode curr;
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        
        curr = root;
        st   =  new Stack<>();
        
    }
    
    public int next() {
        
        
        
        
    }
    
    public boolean hasNext() {
        
        return !st.isEmpty() || curr != null;
    }
}
*/