//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int[] visited = new int[n];
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i< n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i< m; i++){
            int tar = edges[i][0];
            int val = edges[i][1];
            
            graph.get(tar).add(val);
            graph.get(val).add(tar);
        }
        
        ArrayList<String> queue = new ArrayList<>();
        visited[src] = 0;
        
        queue.add(src+":"+0);
        
        while(queue.size() > 0){
            String currentPair = queue.remove(0);
            int node = Integer.parseInt(currentPair.split(":")[0]);
            int distance = Integer.parseInt(currentPair.split(":")[1]);
            
            ArrayList<Integer> adjs = graph.get(node);
            
            for(Integer ad : adjs){
                if(distance+1 < visited[ad]){
                    visited[ad] = distance + 1;
                    queue.add(ad+":"+(distance+1));
                }
            }
            
        }
        
        for(int i=0; i<visited.length; i++){
            if(visited[i] >= Integer.MAX_VALUE)visited[i] = -1;
        }
        
        return visited;
        
    }
}
