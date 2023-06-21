class Solution {
    public boolean ispos(int []position,int m,int limit){
        int no=1;
        int pla=position[0];
        for(int i=0;i<position.length;i++){
            if(position[i]-pla>=limit){
                no++;
                pla=position[i];
            }
        }
        return no>=m;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int s=0;
        int e=0;
        int ans=-1;
        for(int i=1;i<position.length;i++){
            s=Math.min(s,position[i]-position[i-1]);
            
        }
        e=position[position.length-1]-position[0];
        if(position.length<m)return -1;
        while(s<=e){
            int mid=(s+e)/2;
            if(ispos(position,m,mid)){
                ans=mid;
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return ans;
    }
}