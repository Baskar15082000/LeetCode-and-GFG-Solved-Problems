//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution

{
      class pair{
		int node;
		int color;
		pair(int node,int color){
			this.node=node;
			this.color=color;
		}
	}
	public boolean bfs(ArrayList<ArrayList<Integer>> graph,int path [],int node){
			Queue<pair> q=new LinkedList<>();
		    q.add(new pair(node,1));
		    while(q.size()>0){
				pair p=q.remove();
				if(path[p.node]!=0) continue;
				path[p.node]=p.color;
				int opcolor=1;
				if(p.color==1){
					opcolor=-1;
				}
				for(int val:graph.get(p.node)){
					if(path[val]==0){
						q.add(new pair(val,opcolor));
					}
					if(path[val]==p.color){
						return false;
					}
				}
			}
				return true;
		
	}
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>graph)
    {
        // Code here
        int path[]=new int [V];
        for(int i=0;i<V;i++){
            if(path[i]==0){
            boolean ispos=    bfs(graph,path,i);
            if(!ispos)return false;
            }
        }
        return true;
        
    }
}