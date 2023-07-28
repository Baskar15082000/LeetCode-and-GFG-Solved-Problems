public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int A) {
        
        String str=Integer.toBinaryString(A);
		String s="";
        
		
		int si=31-str.length();
		for(int i=0;i<=si;i++){
			str="0"+str;
		}
       
		for(int i=str.length()-1;i>=0;i--){
			s=s+str.charAt(i);
		}
         
		
		return (int)Long.parseLong(s,2);
	//return 0;
    }
}