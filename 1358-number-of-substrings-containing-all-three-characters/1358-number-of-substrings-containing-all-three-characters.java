class Solution {
    public boolean matching(HashMap<Character,Integer> map,HashMap<Character,Integer> curr){
		for(char key:map.keySet()){
			if(!curr.containsKey(key))return false;
			if(curr.get(key)<map.get(key))return false;
			
		}
		return true;
	}
    public int numberOfSubstrings(String s) {
         HashMap<Character,Integer> map=new HashMap<>();
		   HashMap<Character,Integer> curr=new HashMap<>();
		   map.put('a',1);
		   map.put('b',1);
		   map.put('c',1);
		   int sp=0;
		   int ep=0;
		   int t=0;
		   int len=0;
		   while(ep<s.length()){
			   char ch=s.charAt(ep);
			   curr.put(ch,curr.getOrDefault(ch,0)+1);
			   while(matching(map,curr)){
				   
				   char c=s.charAt(sp);
				   curr.put(c,curr.get(c)-1);
				   t++;
				   sp++;
                   
			   }
			   len+=t;
			   ep++;
		   }
		   return len;
    }
}