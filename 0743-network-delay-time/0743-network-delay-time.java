class Solution {
      class Edge{
		   int node;
		   int wsf;
		   Edge(int node,int wsf){
			   this.node=node;
			   this.wsf=wsf;
		   }
	   }
	class pair{
		int node;
		int wsf;
		pair(int node,int wsf){
			this.node=node;
			this.wsf=wsf;
		}
	}
    public int networkDelayTime(int[][] times, int N, int k) {
        		   ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
		   for(int i=0;i<=N;i++){
			   graph.add(new ArrayList<Edge>());
		   }
		   for(int arr[]:times){
			   int a=arr[0];
			   int b=arr[1];
			   int c=arr[2];
			   graph.get(a).add(new Edge(b,c));
		   }
		   PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
			   return a.wsf-b.wsf;
		   });
		   boolean path[]=new boolean[N+1];
		   pq.add(new pair(k,0));
		   int max=-1;
		   while(pq.size()>0){
			   pair p=pq.remove();
			   if(path[p.node]==true)continue;
			   max=Math.max(max,p.wsf);
			   path[p.node]=true;
			   for(Edge val:graph.get(p.node)){
				   if(path[val.node]!=true){
					   pq.add(new pair(val.node,p.wsf+val.wsf));
				   }
			   }
		   }
		   for(int i=1;i<=N;i++){
			   if(path[i]==false)return -1;
		   }
		   return max;
    }
}