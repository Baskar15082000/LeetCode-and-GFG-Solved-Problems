//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static boolean matching(HashMap<Character,Integer> map,HashMap<Character,Integer> curr){
       for(char val:map.keySet()){
			
			if(!curr.containsKey(val))return false;
			if(curr.get(val)<map.get(val))return false;
			
		}
		return true;
    }
    public static String smallestWindow(String s, String p)
    {
        // Your code here
      		HashMap<Character,Integer> map=new HashMap<>();
			HashMap<Character,Integer> curr=new HashMap<>();
		for(int i=0;i<p.length();i++){
			char ch=p.charAt(i);
			map.put(ch,map.getOrDefault(ch,0)+1);
			
		}
		int sp=0;
		int ep=0;
		int length=Integer.MAX_VALUE;
		String ans="-1";
		while(ep<s.length()){
			char ch=s.charAt(ep);
			curr.put(ch,curr.getOrDefault(ch,0)+1);
			while(matching(map,curr)){
				if(length>(ep-sp+1)){
				length=Math.min(length,ep-sp+1);
					
				ans=s.substring(sp,ep+1);
				}
				char c=s.charAt(sp);
				curr.put(c,curr.get(c)-1);
				sp++;
			}
			ep++;
		}
		return ans;
    }
}