class Solution {
    boolean ispos(int mid,int w[],int days){
        int day=1;
        int sum=0;
        for(int i:w){
            if(sum+i<=mid){
                sum+=i;
            }
            else{
                day++;
                sum=i;
            }
        }
        return day<=days;
        
    }
    public int shipWithinDays(int[] weights, int days) {
        int s=Integer.MIN_VALUE;
        int e=0;
        for(int i:weights){
            s=Math.max(i,s);
            e+=i;
        }
        int ans=0;
        while(s<=e){
            int mid=(s+e)/2;
            if(ispos(mid,weights,days)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}