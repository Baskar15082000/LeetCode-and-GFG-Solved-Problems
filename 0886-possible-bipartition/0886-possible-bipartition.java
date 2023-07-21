class Solution {
    class pair{
        int node;
        int color;
        pair(int node,int color){
            this.node=node;
            this.color=color;
        }
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> graph,int path[],int node){
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(node,1));
        while(q.size()>0){
           pair p=q.remove();
           if(path[p.node]!=0)continue;
           path[p.node]=p.color;
            int opcolor=1;
            if(p.color==1){
                opcolor=-1;
            }
           for(int val:graph.get(p.node)){
               if(path[val]==0){
                   q.add(new pair(val,opcolor));
               }
               if(path[val]==p.color)return false;
           }
            
        }
        return  true;
       
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int path[]=new int[n+1];
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int arr[]:dislikes){
            int a=arr[0];
            int b=arr[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=1;i<=n;i++){
            if(path[i]==0){
                boolean ispos=bfs(graph,path,i);
                if(!ispos)return false;
            }
        }
        return true;
    }
}