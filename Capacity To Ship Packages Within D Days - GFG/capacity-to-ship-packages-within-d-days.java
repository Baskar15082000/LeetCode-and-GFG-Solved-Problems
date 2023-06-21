//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean ispos(int A[],int B,int limit){
	int days=1;
	int sum=0;
	for(int n:A){
		if(sum+n<=limit){
			sum+=n;
		}
		else{
			days++;
			sum=n;
		}
	}
	return days<=B;
	}
    static int leastWeightCapacity(int[] A, int N, int B) {
        // code here 
        int s=0;
		int e=0;
		for(int n:A){
			s=Math.max(n,s);
			e=e+n;
		}
		int  ans=-1;
		while(s<=e){
			int mid=(s+e)/2;
			if(ispos(A,B,mid)){
				e=mid-1;
				ans=mid;
			}
			else{
				s=mid+1;
			}
		}
		return ans;
    }
};