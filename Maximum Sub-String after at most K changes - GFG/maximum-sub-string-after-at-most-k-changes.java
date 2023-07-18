//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution

{  
    public int repeat(HashMap<Character,Integer> map){
    int count=0;
    for(char k:map.keySet()){
        if(count<map.get(k)){
            count=map.get(k);
        }
        
    }
    return count;
    }
    public int characterReplacement(String s, int k)
    {
        // code here
        	HashMap<Character,Integer> map=new HashMap<>();
		int sp=0;
		int ep=0;
		int len=-1;
		while(ep<s.length()){
			char ch=s.charAt(ep);
			map.put(ch,map.getOrDefault(ch,0)+1);
			int repeat=repeat(map);
			while((ep-sp+1)-repeat>k){
				char c=s.charAt(sp);
				map.put(c,map.get(c)-1);
				sp++;
			}
			len=Math.max(len,ep-sp+1);
			ep++;
		}
		return len;
    }
}