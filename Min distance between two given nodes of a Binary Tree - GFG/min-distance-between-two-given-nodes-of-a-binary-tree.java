// { Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}
// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    
    static Node lca(Node root, int n1 , int n2) {
        
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        
        Node lst = lca(root.left,n1,n2);
        Node rst = lca(root.right,n1,n2);
        
        
        if(lst == null){
            return rst;
        }
        
        
        if(rst == null){
            return lst;
        }
        
        return root;
    }
    
    
    static void traverse(Node root, int level, int[] levels, Node lca, int a, int b){
        
        if(root == null){
            return;
        }
        
        if(root.data == lca.data && levels[0] == -1){
            levels[0] = level;
        }
        if(root.data == a && levels[1] == -1){
            levels[1] = level;
        }
        if(root.data == b && levels[2] == -1){
            levels[2] = level;
        }
        
        traverse(root.left, level+1,levels,lca,a,b);
        traverse(root.right, level+1,levels,lca,a,b);
        
    }
    
    int findDist(Node root, int a, int b) {
        
       Node lca = lca(root,a,b);
       
       int[] levels = new int[3];
       
       levels[0] = -1;
       levels[1] = -1;
       levels[2] = -1;
        
       traverse(root,0,levels,lca,a,b);
       
       
       return levels[1] + levels[2] - 2*levels[0];
    }
}