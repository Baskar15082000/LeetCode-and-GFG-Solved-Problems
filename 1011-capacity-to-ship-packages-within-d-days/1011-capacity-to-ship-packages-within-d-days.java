class Solution {
    public boolean ispos(int A[],int days,int limit){
        int nod=1;
        int sum=0;
        for(int n:A){
            if(sum+n<=limit){
                sum+=n;
            }
            else{
                nod++;
                sum=n;
            }
        }
        return nod<=days;
    }
    public int shipWithinDays(int[] A, int days) {
        int s=0;
		int  e=0;
		for(int n:A){
			s=Math.max(n,s);
			e=e+n;
		}
		int ans=-1;
		while(s<=e){
			int mid=(s+e)/2;
			if(ispos(A,days,mid)){
				e=mid-1;
				ans=mid;
			}
			else{
				s=mid+1;
			}
		}
		return ans;
    }
}