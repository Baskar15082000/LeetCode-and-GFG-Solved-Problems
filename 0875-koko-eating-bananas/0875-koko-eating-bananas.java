class Solution {
    int ispos(int mid,int piles[]){
    
        int sum=0;
        for(int i:piles){
            sum+=(Math.ceil((double)i/(double)mid));
        }
        return sum;
        
    }
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=Integer.MIN_VALUE;
        for(int i:piles){
            e=Math.max(e,i);
        }
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            int b=ispos(mid,piles);
            if(b<=h){
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