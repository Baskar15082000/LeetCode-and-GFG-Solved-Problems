class Solution {
    boolean ispos(int mid,int day[],int m,int k){
        int c=0;
        int no=0;
        for(int i:day){
            if(i<=mid){
                c++;
            }
            else{
                no+=(c/k);
                c=0;
            }
        }
        no+=c/k;
        return no>=m;
    }
    public int minDays(int[] day, int m, int k) {
        int n=day.length;
        if(n<(m*k))return -1;
        int s=Integer.MAX_VALUE;
        int e=Integer.MIN_VALUE;
        for(int i:day){
            s=Math.min(s,i);
          
            e=Math.max(e,i);
        }
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
           
            if( ispos(mid,day,m,k)){
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

