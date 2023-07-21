class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int inde[]=new int[n];
        int ans[]=new int [n];
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int arr[]:prerequisites){
            graph.get(arr[1]).add(arr[0]);
            inde[arr[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inde[i]==0){
                q.add(i);
            }
        }
        int i=0;
        while(q.size()>0){
            int topo=q.remove();
            ans[i]=topo;
            i++;
            for(int val:graph.get(topo)){
                inde[val]--;
                if(inde[val]==0){
                    q.add(val);
                }
            }
            
        }
        if(i<n)return new int[0];
        return ans;
    }
}