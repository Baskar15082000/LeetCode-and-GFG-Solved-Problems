class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<List<String>> ();
        List<String> path=new ArrayList<>();
        partition(s,0,list,path);
        return list; 
        
    }
    public void partition(String s,int index,List<List<String>>list,List<String>path) {
        if(index>=s.length()){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(ispalindrome(s,index,i)==true){
                path.add(s.substring(index,i+1));
                partition(s,i+1,list,path);
                path.remove(path.size()-1);
            }
     
        }
    }
    public boolean ispalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}