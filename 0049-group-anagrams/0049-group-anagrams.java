class Solution {
    
    public String code(String str){
        char arr[]=new char[26];
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            arr[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                sb.append((char)i+'a');
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] wordArr) {
          HashMap<String,ArrayList<String>> map1=new HashMap<>();
		ArrayList<String> list=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
		for(String val:wordArr){
			String str=code(val);
			if(map1.containsKey(str)){
				ArrayList<String> s=map1.get(str);
				s.add(val);
				map1.put(str,s);
			}
			else{
				ArrayList<String> s=new ArrayList<>();
				list.add(str);
				s.add(val);
				map1.put(str,s);
			}
		}
		
		for(String val:list){
			String key=val;
			ArrayList<String> l=map1.get(key);
			ans.add(l);
        }
        return ans;
    }
}