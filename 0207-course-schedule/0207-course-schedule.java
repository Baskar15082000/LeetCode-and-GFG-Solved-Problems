class Solution {
    public boolean canFinish(int N, int[][] pre) {
         ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        int in[]=new int[N];
        for(int i=0;i<N;i++){
            for(int val:adj.get(i)){
                in[val]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(in[i]==0){
                q.add(i);
            }
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
        if(count==N)return true;
        return false;
       
    }
}