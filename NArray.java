//calculate shortest Path in N-Ary Tree.
//Sample input

// 13            - Total number of edges
// A B 5
// B E 11
// B F 5
// F N 3
// F M 1
// N O 1
// A C 10
// C G 10
// A D 3
// D H 12
// D J 7
// J L 5
// J K 3
// A           - Root Node 

//Output
//11         - Shortest Path from Root to a Leaf node.

import java.util.*;
import java.io.*;
public class NArray {
	 static class Node { 
        String name; 
  		ArrayList<Node> childrenList = new ArrayList<Node>(); 
  		ArrayList<Integer> weightList = new ArrayList<Integer>(); 
  	
  		 Node(int weight, String name, Node child) { 
        	if (child != null) {
        		childrenList.add(child);
        		weightList.add(weight);
        	}
            this.name = name; 
        }
        
        void addChildren (Node child, int weight) {
        	childrenList.add(child);
        	weightList.add(weight);
        } 
   } 
    public static void main(String[] args) throws IOException   
    { 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int original = Integer.parseInt(br.readLine());
		//Node root = null;
		int t = original;
		
		Map<String, Node> createdNodes = new HashMap<String, Node>();
		
		while(t-->0) {
		    String str = br.readLine();
		    String parent = str.split(" ")[0];
		    String child = str.split(" ")[1];
    		int weight = Integer.parseInt(str.split(" ")[2]);
    	
    		if (!createdNodes.containsKey(child)) {
    			Node childNode = new Node(0, child, null);
    			createdNodes.put(child, childNode);
    	
    	    	if (!createdNodes.containsKey(parent)) {
    		 		Node parentNode = new Node(weight, parent, childNode);
    		 		createdNodes.put(parent, parentNode);
    			}
    			
    			else if (createdNodes.containsKey(parent)) {
    				Node parentNode = createdNodes.get(parent);
    				parentNode.addChildren(childNode, weight);
    			}
    		}	
    	}
    	
    	String root = br.readLine();
    	Node rootNode = createdNodes.get(root);
    	
    	System.out.println(rootNode.childrenList.size());
    	
    	int min = Integer.MAX_VALUE;
    	min = calculateMin(rootNode, 0, min);
    	
    	System.out.println(min);
  
       
    }
    
    
    public static int calculateMin (Node root, int min, int globalMin) {
    	if (root.childrenList.size() == 0)
    		return min;
    	
    	for (int i = 0; i < root.childrenList.size() ; i++) {
    		int cost = calculateMin(root.childrenList.get(i), min, globalMin) + root.weightList.get(i);
    		
    		if (cost < globalMin)
    			globalMin = cost;
    	}
    	
    	return globalMin;
    
    } 
}
