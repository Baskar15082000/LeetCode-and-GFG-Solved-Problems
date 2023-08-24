//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // public boolean ispos(ArrayList<ArrayList<Integer>> adj,int node,int vis[],int path[]){
    //     vis[node]=1;
    //     path[node]=1;
    //     for(int val:adj.get(node)){
    //         if(vis[val]==0){
    //             if(ispos(adj,val,vis,path)==true){
    //                 return true;
    //             }
                
    //         }
    //         else if(path[val]==1)return true;
    //     }
    //     path[node]=0;
    //     return false;
    // }
    // Function to detect cycle in a directed graph.
    // public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    //     int vis[]=new int[V];
    //     int path[]=new int[V];
    //     for(int i=0;i<V;i++){
    //         if(vis[i]==0){
    //             if(ispos(adj,i,vis,path)==true){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
        
    // }
     public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       // int vis[]=new int[V];
        int in[]=new int[V];
        for(int i=0;i<V;i++){
            for(int val:adj.get(i)){
                in[val]++;
            }
             
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(in[i]==0)q.add(i);
        }
        int count=0;
        while(q.size()>0){
            int node=q.remove();
            count++;
            for(int val:adj.get(node)){
                in[val]--;
                if(in[val]==0)q.add(val);
            }
        }
        if(count==V)return false;
        return true;
        
    }
}