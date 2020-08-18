// https://practice.geeksforgeeks.org/problems/largest-bst/1
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
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
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
        
                  // Create the right child for the curr node
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
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int val = 0;
    static int largestBst(Node root)
    {
        val = 0;
        Answer ans = solution(root);   
        return val;
    }
    
    static Answer solution(Node root) {
        if (root == null)
            return new Answer(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            
        Answer left = solution(root.left);
        Answer right = solution(root.right);
        
        // System.out.println(root.data);
        // System.out.println(left.max);
        if (root.data > left.max && root.data < right.min && left.isBST && right.isBST) {
            
            int sizeCurr = right.size+left.size+1;
            if (sizeCurr > val)
                val = sizeCurr;
            return new Answer(true, Math.min(right.min, root.data) , Math.max(left.max, root.data),  sizeCurr);
        }
        else {
            return new Answer(false, -1 , -1, 0);
        }
    }
    
}

class Answer {
    boolean isBST = false;
    int min = 0;
    int max = 0;
    int size = 0;
    
    Answer (boolean BST, int minCurr, int maxCurr, int sizeCurr) {
        isBST = BST;
        min = minCurr;
        max = maxCurr;
        size = sizeCurr;
    }
}