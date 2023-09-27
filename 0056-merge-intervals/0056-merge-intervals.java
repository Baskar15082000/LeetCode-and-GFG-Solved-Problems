class Solution {
    public int[][] merge(int[][] in) {
         if (in == null || in.length == 0) {
            return new int[0][];
        }
        List<int[]> list=new ArrayList<>();
        Arrays.sort(in,(a,b)->a[0]-b[0]);
        int curr[]=in[0];
        for(int i=1;i<in.length;i++){
            int next[]=in[i];
            if(curr[1]>=next[0]){
                curr[1]=Math.max(curr[1],next[1]);
            }
            else{
                list.add(curr);
                curr=next;
            }
        }
        list.add(curr);
        return list.toArray(new int[0][]);
        
    }
}