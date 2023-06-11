class Solution {
    public int strStr(String haystack, String needle) {
        String s=haystack;
        if(haystack.contains(needle)!=true) return -1;
        s=s.replaceFirst(needle,"0");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')return i;
        }
        return 0;
    }
}