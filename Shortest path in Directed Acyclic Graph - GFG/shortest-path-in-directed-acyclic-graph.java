//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    class pair{
        int node;
        int wt;
        pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    
    public void dfs(int i,int vis[],Stack<Integer> st,ArrayList<ArrayList<pair>> adj){
        vis[i]=1;
        for(pair v:adj.get(i)){
            
            if(vis[v.node]==0){
                dfs(v.node,vis,st,adj);
            }
            
        }
        st.push(i);
        
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<pair>> adj=new ArrayList<>();
		for(int i=0;i<N;i++){
		    ArrayList<pair>temp=new ArrayList<>();
		    adj.add(temp);
		}
		for(int i=0;i<M;i++){
		    int u=edges[i][0];
		    int v=edges[i][1];
		    int wt=edges[i][2];
		    adj.get(u).add(new pair(v,wt));
		}
			int vis[]=new int[N];
	    Stack<Integer>st=new Stack<>();
	    
	
		
		for(int i=0;i<N;i++){
		    if(vis[i]==0){
		        dfs(i,vis,st,adj);
		    }
		}

		int ans[]=new int[N];
		for(int i=0;i<N;i++){
		    ans[i]=(int)(1e9);
		}
		ans[0]=0;
		while(st.size()>0){
		    int n=st.pop();
		    for(pair val:adj.get(n)){
		        if((ans[n]+val.wt )<ans[val.node]){
		            ans[val.node]=val.wt+ans[n];
		        }
		    }
		}
		for(int i=0;i<N;i++){
		   if( ans[i]==(int)1e9)ans[i]=-1;
		}
		return ans;
		
	}
}