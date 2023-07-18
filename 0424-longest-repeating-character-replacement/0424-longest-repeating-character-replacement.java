class Solution {
    public int repeat(HashMap<Character,Integer> map){
        int count=0;
        for(char key:map.keySet()){
            if(map.get(key)>count){
                count=map.get(key);
            }
        }
        return count;
    }
    public int characterReplacement(String s, int k) {
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