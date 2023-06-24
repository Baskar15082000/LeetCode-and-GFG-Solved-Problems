class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
		int l=0;
        int n=s.length();
		int r=0;
		int length=0;
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