//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
        // code here
        int n=s.length();
        int l=0;
        int r=0;
        int length=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(r<n){
            
            
            char ch=s.charAt(r);
            if(map.containsKey(ch)){
                l=Math.max(l,map.get(ch)+1);
            }
            map.put(ch,r);
            length=Math.max(length,r-l+1);
            r++;
            
        }
        return length;
    }
}