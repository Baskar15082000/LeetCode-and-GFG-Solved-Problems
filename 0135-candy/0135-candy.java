class Solution {
    public int candy(int[] arr) {
        int n=arr.length;
        int l[]=new int [n];
        int r[]=new int [n];
        l[0]=1;
        r[n-1]=1;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1])l[i]=l[i-1]+1;
            else l[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1])r[i]=r[i+1]+1;
            else{
                r[i]=1;
            }
        }
        int min=0;
        for(int i=0;i<n;i++){
            int t=Math.max(l[i],r[i]);
            min+=t;
        }
        return min;
    }
}