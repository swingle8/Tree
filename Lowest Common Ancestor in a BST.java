// { Driver Code Starts
//Initial Template for Java


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
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
            //Scanner sc = new Scanner(System.in);
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    BST g = new BST();
        	    String X = br.readLine();
        	    String arr[] = X.split(" ");
        	    int x , y;
			    x = Integer.parseInt(arr[0]);
			    y = Integer.parseInt(arr[1]);
			    System.out.println(g.LCA(root,x,y).data);
                t--;
            
        }
    }
  
}

// } Driver Code Ends


//User function Template for Java

/*
structure of Node is as follows:
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
*/

class BST
{   
    // Returns the LCA of the nodes with values n1 and n2
    // in the BST rooted at 'root' 
    Node ans = null;
	Node LCA(Node root, int n1, int n2)
	{
	    if (root == null)
	        return root;
	    ans = null;
	    boolean found1 = false;
	    boolean found2 = false;
        LCATwoSides(root, n1, n2, found1, found2);
        if (ans == null)
            return root;
        return ans;
    }
    
    
    boolean LCATwoSides (Node root, int n1, int n2, boolean found1, boolean found2) {
        if (root == null)
            return false;
        
        if (root.data == n1 || root.data == n2)
            found1 = true;
        
        boolean left = false;
        boolean right = false;
        if (n1 > root.data && n2 > root.data) {
            right = LCATwoSides (root.right, n1, n2, false, false);
        }
        else if (n1 <= root.data && n2 <= root.data) {
            left = LCATwoSides (root.left, n1, n2, false, false);
        }
        else {
            left = LCATwoSides (root.left, n1, n2, false, false);
            right = LCATwoSides (root.right, n1, n2, false, false);
        }
        
        if (((left && right) || (left && found1) || (right && found1)) && ans == null)
            ans = root;
        
        return (left || right || found1);
    }
    
}
