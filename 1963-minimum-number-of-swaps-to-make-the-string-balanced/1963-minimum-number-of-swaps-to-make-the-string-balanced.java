class Solution {
    public int minSwaps(String s) {
        int count=0;
        int min=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==']')count++;
            if(ch=='[')count--;
            min=Math.max(min,count);
        }
        return (min+1)/2;
    }
}