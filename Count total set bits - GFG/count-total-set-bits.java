//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int N){
        
        // Your code hereint 
        int two = 2, ans = 0;
        int n = N;
    while (n != 0) {
        ans += (N / two) * (two >> 1);
        if ((N & (two - 1)) > (two >> 1) - 1)
            ans += (N & (two - 1)) - (two >> 1) + 1;
        two <<= 1;
        n >>= 1;
    }
    return ans;

        
      }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends