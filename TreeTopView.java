qInde// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}


class GfG{
    
    public static void main(String[] args)throws IOException{
        //Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
       
        while(t > 0)
           {
               Queue<Node> q = new LinkedList<>();
        
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");
            
            Node root = null;
            int j=0;
            while(n > 0){
            int a1 = Integer.parseInt(input[j]);
            int a2 = Integer.parseInt(input[j+1]);
            char lr = input[j+2].charAt(0);
            j+=3;
            
            if(root == null)
            {
                root = new Node(a1);
                q.add(root);
            }
            
            Node pick = q.peek();
            
            q.remove();
            
            if(lr=='L'){
                pick.left = new Node(a2);
                q.add(pick.left);
            }
            a1 = Integer.parseInt(input[j]);
            a2 = Integer.parseInt(input[j+1]);
            lr = input[j+2].charAt(0);
            j += 3;
            
            if(lr=='R'){
                pick.right = new Node(a2);
                q.add(pick.right);
            }
            
            n-=2;
        }
            new View().topView(root);
            System.out.println();
            t--;
        }
    }
}

   


// } Driver Code Ends


//User function Template for Java



/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class View
{
    // function should print the topView of the binary tree
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    static void topView(Node root)
    {
        map.clear();
       Queue<Node> q = new LinkedList<Node>();
       Queue<Integer> qIndex = new LinkedList<Integer>();
       //int num = 0;
       q.add(root);
       qIndex.add(0);
        int min = 0;
        int max = 0;
       
       
        while (! q.isEmpty()) {
           int size = q.size();
           
           for (int i = 0 ; i < size ; i ++) {
               Node curr = q.remove();
               int currIndex = qIndex.remove();
               
               if (! map.containsKey(currIndex)) {
                   map.put(currIndex, curr.data);
                    if (currIndex < min)
                        min = currIndex;
                    if (currIndex > max)
                        max = currIndex;
               }
               
               if (curr.left != null) {
                    q.add(curr.left);
                    qIndex.add(currIndex-1);
               }
               
               if (curr.right != null) {
                    q.add(curr.right);
                    qIndex.add(currIndex+1);
               }
           }
        }
        
        
        //ArrayList<Integer> al = new ArrayList<Integer>();
        StringBuffer sb = new StringBuffer();
        while (min <= max) {
            sb.append(map.get(min) + " ");
            min++;
        }
        
        System.out.print(sb);
      
    }
        
        
    
}