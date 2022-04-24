// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair{
    Node head;
    Node tail;
    
    Pair(Node head, Node tail){
        
        this.head = head;
        this.tail = tail;
    }
}

class Solution
{
   Pair convertToDLL(Node root){
        
        if(root == null){
            return new Pair(null,null);
        }
        
        Pair lst = convertToDLL(root.left);
        Pair rst  = convertToDLL(root.right);
        
        Node head = root;
        Node tail = root;
        
        root.left = lst.tail;
        
        if(lst.tail != null){
            lst.tail.right = root;
            head = lst.head;
        }
        
        root.right = rst.head;
        
        if(rst.head != null){
            rst.head.left = root;
            tail = rst.tail;
        }
        
        return new Pair(head, tail);
    }
    
    // root : the root Node of the given BST
    // target : the target sum
    public int isPairPresent(Node root, int target)
    {
        Pair res = convertToDLL(root);
        
        Node p1 = res.head;
        Node p2 = res.tail;
        
        while(p1.data < p2.data){
            
            int sum = p1.data + p2.data;
            
            if(sum == target){
                return 1;
            }else if(sum > target){
                p2 = p2.left;
            }else
                p1 = p1.right;
            
        }
        
        return 0;
    }
}
