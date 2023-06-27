class Solution {
    public String minWindow(String s, String t) {
        		HashMap<Character,Integer> map1 = new HashMap<>();
		for(int i=0;i<t.length();i++){
			char ch=t.charAt(i);
			if(map1.containsKey(ch)){
				map1.put(ch,map1.get(ch)+1);
			}
			else{
				map1.put(ch,1);
			}
		}
		String ans="";
		HashMap<Character,Integer> map2=new HashMap<>();
		int match=t.length();
		int count=0;
		int l=0;
		int r=0;
		while(true){
			boolean f1=false;
			boolean f2=false;
			
			if(r<s.length() && match>count){
				char ch=s.charAt(r);
				if(map1.containsKey(ch)){
					if(map2.getOrDefault(ch,0)<map1.get(ch)){
						count++;
					}
				}
				if(map2.containsKey(ch)){
					map2.put(ch,map2.get(ch)+1);
				}
				else{
					map2.put(ch,1);
				}
				//System.out.print("Ff");
				f1=true;
                
			 r++;
			}
			else if(l<r && match==count){
				String sub=s.substring(l,r);
				if(ans=="" || (ans.length()>sub.length())){
					ans=sub;
					//System.out.print(ans);
				}
				
				char cha=s.charAt(l);
				if(map1.containsKey(cha)){
					if(map2.get(cha)<=map1.get(cha)){
						 count--;
					}
				}
				map2.put(cha,map2.get(cha)-1);
				if(map2.get(cha)==0){
					map2.remove(cha); 
				}
				l++;
				f2=true;
			
			}
			if(f1==false && f2==false) break;
		}
		return ans;
    }
}