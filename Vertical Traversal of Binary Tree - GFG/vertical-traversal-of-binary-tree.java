// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null){return res;}
        
        Queue<NodePair> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minHd = Integer.MAX_VALUE;
        int maxHd = Integer.MIN_VALUE;
        q.add(new NodePair(root,0));
        
        while(!q.isEmpty()){
            
            NodePair p = q.poll();
            
            maxHd = Math.max(maxHd, p.hd);
            minHd = Math.min(minHd, p.hd);
            
            if(map.containsKey(p.hd)){
                map.get(p.hd).add(p.node.data);
            }else{
                List<Integer> li = new ArrayList<>();
                li.add(p.node.data);
                map.put(p.hd, li);
            }
            
            
            if(p.node.left != null){
                q.add(new NodePair(p.node.left, p.hd-1));
            }
            
            if(p.node.right != null){
                q.add(new NodePair(p.node.right, p.hd+1));
            }
            
        }
        
        
        for(int i = minHd; i <= maxHd; i++){
            
            for(int num : map.get(i)){
                res.add(num);
            }
            
        }
        
        return res;
    }
}

class NodePair{
    
    Node node;
    int hd; //horizontal distance from the root node
    
    NodePair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}