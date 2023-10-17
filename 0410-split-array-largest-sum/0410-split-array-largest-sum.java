class Solution {
    
       boolean ispos(long mid,int A[],int M){
        int st=1;
        int sum=0;
        for(int i:A){
            if((sum+i) <= mid){
                sum+=i;
            }
            else{
                st++;
                sum=i;
            }
        }
           
        return st<=M;
       }
    
    public int splitArray(int[] A, int k) {
        int s=0;
        int e=0;
        int n=A.length;
        for(int i:A){
            s=Math.max(s,i);
            e+=i;
        }
        if(n==1)return A[0];
       // if(k>n)return -1;
        
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(ispos(mid,A,k)){
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