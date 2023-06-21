//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean ispos(int stalls[],int cows,int limit){
        int noofc=1;
        int stal=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-stal>=limit){
                noofc++;
                stal=stalls[i];
            }
        }
        return noofc>=cows;
    }
    public static int solve(int n, int cows, int[] stalls) {
        Arrays.sort(stalls);
        int s=Integer.MAX_VALUE;
        int e=0;
     //  
        if(n<cows)return -1;
        for(int i=1;i<n;i++){
            s=Math.min(stalls[i]-stalls[i-1],s);
        }
         
        e=stalls[n-1]-stalls[0];
       // System.out.print(e);
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(ispos(stalls,cows,mid)){
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