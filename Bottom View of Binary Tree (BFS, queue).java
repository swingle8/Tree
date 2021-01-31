// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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
    	        Tree g = new Tree();
			    ArrayList <Integer> res = g.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}

// } Driver Code Ends


//User function Template for Java

// class Node
// {
//     int data; //data of the node
//     int hd; //horizontal distance of the node
//     Node left, right; //left and right references
 
//     // Constructor of tree node
//     public Node(int key)
//     {
//         data = key;
//         hd = Integer.MAX_VALUE;
//         left = right = null;
//     }
// }


class Tree
{
    int min = 0;
    int max = 0;
    // Method that returns the bottom view.
    public ArrayList <Integer> bottomView(Node root) {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        min = 0;
        max = 0;
        
        Queue<Bit> q = new LinkedList<Bit>();
        q.add(new Bit(root, 0));
        while (! q.isEmpty()) {
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                Bit curr = q.remove();
                Node currNode = curr.n;
                map.put(curr.level, currNode);
                min = Math.min (min, curr.level);
                max = Math.max (max, curr.level);
                if (currNode.left != null)
                    q.add(new Bit(currNode.left, curr.level-1));
                if (currNode.right != null)
                    q.add(new Bit(currNode.right, curr.level+1));
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = min ; i <= max ; i++)
            ans.add(map.get(i).data);
        return ans;
    }
}


class Bit {
    Node n = null;
    int level = 0;
    Bit (Node root, int lev) {
        n = root;
        level = lev;
    }
}