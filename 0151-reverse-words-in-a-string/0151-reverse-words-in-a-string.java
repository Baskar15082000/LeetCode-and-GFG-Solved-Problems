class Solution {
    public String reverseWords(String s) {
        		String arr[]=s.split(" ");
		String st=" ";

		for(int i=arr.length-1;i>=0;i--){
		String str=arr[i];
			str.replace("\\s+","");
			if(str.equals("")){
				continue;
			}
			else{
				str=str.trim();
				
		 st=st+" "+str;
			}
			
    }
		return st.strip();
}
}