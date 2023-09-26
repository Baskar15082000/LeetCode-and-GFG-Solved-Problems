class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            while(k>0 && st.size()>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0 && st.size()>0){
            st.pop();
            k--;
        }
        String str="";
        
        
        while(st.size()>0){
            str=st.pop()+str;
        }
         System.out.println(str);
        int i=0;
        while(str.length()>0){
            if(str.charAt(i)=='0'){
               str=str.substring(i+1,str.length());
                i=0;
            }
            else{
                break;
            }
            
        }
        
        if(str.equals(""))return "0";
        return str;
    }
}